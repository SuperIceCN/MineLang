package me.minelang.compiler.parser;

import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.FrameSlotKind;
import com.oracle.truffle.api.source.Source;
import com.oracle.truffle.api.source.SourceSection;
import me.minelang.compiler.lang.nodes.MineNode;
import me.minelang.compiler.lang.nodes.control.*;
import me.minelang.compiler.lang.nodes.function.*;
import me.minelang.compiler.lang.nodes.literial.LiteralNodeFactory;
import me.minelang.compiler.lang.nodes.literial.NanLiteralNodeFactory;
import me.minelang.compiler.lang.nodes.literial.NoneLiteralNodeFactory;
import me.minelang.compiler.lang.nodes.operator.*;
import me.minelang.compiler.lang.nodes.value.GlobalVarReadNodeFactory;
import me.minelang.compiler.lang.nodes.value.GlobalVarWriteNodeFactory;
import me.minelang.compiler.lang.nodes.value.LocalVarReadNodeFactory;
import me.minelang.compiler.lang.nodes.value.LocalVarWriteNodeFactory;
import me.minelang.compiler.lang.types.MineNone;
import me.minelang.compiler.parser.exceptions.InvalidParseNodeException;
import me.minelang.compiler.parser.exceptions.VarNotFoundException;
import me.minelang.compiler.utils.StringUtil;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static me.minelang.compiler.parser.LexicalScope.of;
import static me.minelang.compiler.parser.VisitResult.of;

public final class MineLangASTBuilder extends MineLangBaseVisitor<VisitResult<?>> {
    public final String sourceName;
    public final String sourceContent;
    public final Source truffleSource;

    public final ParseTreeProperty<LexicalScope> lexicalScopes = new ParseTreeProperty<>();
    public final LexicalScope rootLexicalScope;

    public static int ParallelThresholdBase = 32;
    public final int ParallelThreshold;

    public MineLangASTBuilder(String sourceName, String sourceContent, FrameDescriptor rootFrameDescriptor) {
        this.sourceName = sourceName;
        this.sourceContent = sourceContent;
        this.rootLexicalScope = of(null, rootFrameDescriptor);
        this.truffleSource = Source.newBuilder("MineLang", sourceContent, sourceName)
                .encoding(StandardCharsets.UTF_8).build();
        var cores = Runtime.getRuntime().availableProcessors();
        if (cores == 1) {
            ParallelThreshold = Integer.MIN_VALUE;
        } else if (cores == 2) {
            ParallelThreshold = ParallelThresholdBase << 8;
        } else if (cores == 3) {
            ParallelThreshold = ParallelThresholdBase << 5;
        } else if (cores < 6) {
            ParallelThreshold = ParallelThresholdBase << 2;
        } else if (cores < 10) {
            ParallelThreshold = ParallelThresholdBase;
        } else if (cores < 16) {
            ParallelThreshold = (ParallelThresholdBase >> 2) * 3;
        } else {
            ParallelThreshold = ParallelThresholdBase >> 1;
        }
    }

    public VisitResult<?> visit(ParserRuleContext tree) {
        if (tree.children.size() > ParallelThreshold) { // 通常在多核处理器上才有优势
            tree.children = tree.children.parallelStream().filter(each -> !(each instanceof MineLangParser.SplitContext)).toList();
        } else {
            tree.children.removeIf(each -> each instanceof MineLangParser.SplitContext);
        }
        return super.visit(tree);
    }

    @Override
    public VisitResult<?> visitSplit(MineLangParser.SplitContext ctx) {
        return of(NoneLiteralNodeFactory.create().setSourceSection(section(ctx)));
    }

    @Override
    public VisitResult<?> visitProgram(MineLangParser.ProgramContext ctx) {
        scope(ctx, rootLexicalScope);
        var nodes = new ArrayList<MineNode>();
        ctx.expr().stream().filter(exprContext -> !(exprContext instanceof MineLangParser.GlobalExprContext))
                .forEach(exprContext -> nodes.add(visit(scope(exprContext, rootLexicalScope)).singleNode()));
        return of(nodes);
    }

    @Override
    public VisitResult<LexicalScope> visitBlockExpr(MineLangParser.BlockExprContext ctx) {
        return this.visitBlockExpr(ctx, new FrameDescriptor(MineNone.SINGLETON), true);
    }

    public VisitResult<LexicalScope> visitBlockExpr(MineLangParser.BlockExprContext ctx, boolean useInnerFrame) {
        return this.visitBlockExpr(ctx, new FrameDescriptor(MineNone.SINGLETON), useInnerFrame);
    }

    public VisitResult<LexicalScope> visitBlockExpr(MineLangParser.BlockExprContext ctx, FrameDescriptor blockFd, boolean useInnerFrame) {
        var nodes = new ArrayList<MineNode>();
        var fd = of(getScope(ctx), blockFd);
        var exprs = ctx.expr();
        // 执行全局变量提升操作
        var it = exprs.listIterator();
        while (it.hasNext()) {
            var current = it.next();
            if (current instanceof MineLangParser.GlobalExprContext globalExprContext) {
                this.visitGlobalExpr(scope(globalExprContext, fd));
                it.remove();
            }
        }
        // 执行变量声明提升操作
//        (exprs.size() > ParallelThreshold ? exprs.parallelStream() : exprs.stream())
//                .filter(exprContext -> exprContext instanceof MineLangParser.VarSetExprContext varSetExprContext && !fd.isGlobal(varSetExprContext.ID().getText()))
//                .filter(distinctByKey(exprContext -> exprContext.getStart().getText()))
//                .forEach(exprContext -> nodes.add(LocalVarWriteNodeFactory.create(NoneLiteralNodeFactory.create()
//                        , fd.declare(((MineLangParser.VarSetExprContext) exprContext).ID().getText()))));
        exprs.forEach(exprContext -> nodes.add(visit(scope(exprContext, fd)).singleNode()));
        return of(fd, BlockNodeFactory.create(fd.getFrameDescriptor(), useInnerFrame, nodes.toArray(new MineNode[]{}))
                .setSourceSection(section(ctx)));
    }

    @Override
    public VisitResult<?> visitBracketExpr(MineLangParser.BracketExprContext ctx) {
        return of(visit(scope(ctx.expr(), getScope(ctx))).singleNode().setSourceSection(section(ctx)));
    }

    /*
     * 字面量100%不需要记录作用域
     */
    @Override
    public VisitResult<?> visitLiteralExpr(MineLangParser.LiteralExprContext ctx) {
        var ins = LiteralNodeFactory.getInstance();
        if (ctx.STRING() != null) {
            return of(ins.createStringNode(StringUtil.removeQuote(ctx.STRING().getText()))
                    .setSourceSection(section(ctx)));
        } else if (ctx.BOOL() != null) {
            return of(ins.createBoolNode(ctx.BOOL().getText()).setSourceSection(section(ctx)));
        } else if (ctx.NONE() != null) {
            return of(NoneLiteralNodeFactory.create().setSourceSection(section(ctx)));
        } else if (ctx.NAN() != null) {
            return of(NanLiteralNodeFactory.create().setSourceSection(section(ctx)));
        } else if (ctx.INT() != null) {
            return of(ins.createNumberNode(ctx.INT().getText()).setSourceSection(section(ctx)));
        } else if (ctx.DEC() != null) {
            return of(ins.createNumberNode(ctx.DEC().getText()).setSourceSection(section(ctx)));
        } else {
            throw new InvalidParseNodeException(ctx);
        }
    }

    @Override
    public VisitResult<?> visitNotExpr(MineLangParser.NotExprContext ctx) {
        return of(LogicalNotOperatorNodeFactory.create(visit(scope(ctx.expr(), getScope(ctx))).singleNode())
                .setSourceSection(section(ctx)));
    }

    @Override
    public VisitResult<?> visitPositiveNegativeExpr(MineLangParser.PositiveNegativeExprContext ctx) {
        var fd = getScope(ctx);
        if (ctx.PLUS() != null) {
            return of(PositiveOperatorNodeFactory.create(visit(scope(ctx.expr(), fd)).singleNode())
                    .setSourceSection(section(ctx)));
        } else if (ctx.MINUS() != null) {
            return of(NegativeOperatorNodeFactory.create(visit(scope(ctx.expr(), fd)).singleNode())
                    .setSourceSection(section(ctx)));
        } else {
            throw new InvalidParseNodeException(ctx);
        }
    }

    @Override
    public VisitResult<?> visitPlusMinusExpr(MineLangParser.PlusMinusExprContext ctx) {
        var fd = getScope(ctx);
        if (ctx.PLUS() != null) {
            return of(AddOperatorNodeFactory.create(visit(scope(ctx.expr(0), fd)).singleNode(), visit(scope(ctx.expr(1), fd))
                    .singleNode()).setSourceSection(section(ctx)));
        } else if (ctx.MINUS() != null) {
            return of(MinusOperatorNodeFactory.create(visit(scope(ctx.expr(0), fd)).singleNode(), visit(scope(ctx.expr(1), fd))
                    .singleNode()).setSourceSection(section(ctx)));
        } else {
            throw new InvalidParseNodeException(ctx);
        }
    }

    @Override
    public VisitResult<?> visitMultiplyDivideRemainExpr(MineLangParser.MultiplyDivideRemainExprContext ctx) {
        var fd = getScope(ctx);
        if (ctx.MULTIPLY() != null) {
            return of(MultiplyOperatorNodeFactory.create(visit(scope(ctx.expr(0), fd)).singleNode(), visit(scope(ctx.expr(1), fd)).singleNode())
                    .setSourceSection(section(ctx)));
        } else if (ctx.DIVIDE() != null) {
            return of(DivideOperatorNodeFactory.create(visit(scope(ctx.expr(0), fd)).singleNode(), visit(scope(ctx.expr(1), fd)).singleNode())
                    .setSourceSection(section(ctx)));
        } else if (ctx.REMAIN() != null) {
            return of(RemainOperatorNodeFactory.create(visit(scope(ctx.expr(0), fd)).singleNode(), visit(scope(ctx.expr(1), fd)).singleNode())
                    .setSourceSection(section(ctx)));
        } else {
            throw new InvalidParseNodeException(ctx);
        }
    }

    @Override
    public VisitResult<?> visitLogicExpr(MineLangParser.LogicExprContext ctx) {
        var fd = getScope(ctx);
        if (!ctx.AND().isEmpty()) {
            return of(LogicalOrOperatorNodeFactory.create(visit(scope(ctx.expr(0), fd)).singleNode(), visit(scope(ctx.expr(1), fd)).singleNode())
                    .setSourceSection(section(ctx)));
        } else if (!ctx.OR().isEmpty()) {
            return of(LogicalOrOperatorNodeFactory.create(visit(scope(ctx.expr(0), fd)).singleNode(), visit(scope(ctx.expr(1), fd)).singleNode())
                    .setSourceSection(section(ctx)));
        } else {
            throw new InvalidParseNodeException(ctx);
        }
    }

    @Override
    public VisitResult<?> visitIsEqExpr(MineLangParser.IsEqExprContext ctx) {
        var fd = getScope(ctx);
        if (ctx.EQ() != null) {
            return of(EqualOperatorNodeFactory.create(visit(scope(ctx.expr(0), fd)).singleNode(), visit(scope(ctx.expr(1), fd)).singleNode())
                    .setSourceSection(section(ctx)));
        } else if (ctx.NEQ() != null) {
            return of(NotEqualOperatorNodeFactory.create(visit(scope(ctx.expr(0), fd)).singleNode(), visit(scope(ctx.expr(1), fd)).singleNode())
                    .setSourceSection(section(ctx)));
        } else {
            throw new InvalidParseNodeException(ctx);
        }
    }

    @Override
    public VisitResult<?> visitCompareExpr(MineLangParser.CompareExprContext ctx) {
        var fd = getScope(ctx);
        if (ctx.GTR() != null) {
            return of(GreaterOperatorNodeFactory.create(visit(scope(ctx.expr(0), fd)).singleNode(), visit(scope(ctx.expr(1), fd)).singleNode())
                    .setSourceSection(section(ctx)));
        } else if (ctx.GTREQ() != null) {
            return of(GreaterEqualOperatorNodeFactory.create(visit(scope(ctx.expr(0), fd)).singleNode(), visit(scope(ctx.expr(1), fd)).singleNode())
                    .setSourceSection(section(ctx)));
        } else if (ctx.LWR() != null) {
            return of(LowerOperatorNodeFactory.create(visit(scope(ctx.expr(0), fd)).singleNode(), visit(scope(ctx.expr(1), fd)).singleNode())
                    .setSourceSection(section(ctx)));
        } else if (ctx.LWREQ() != null) {
            return of(LowerEqualOperatorNodeFactory.create(visit(scope(ctx.expr(0), fd)).singleNode(), visit(scope(ctx.expr(1), fd)).singleNode())
                    .setSourceSection(section(ctx)));
        } else {
            throw new InvalidParseNodeException(ctx);
        }
    }

    @Override
    public VisitResult<?> visitVarUseExpr(MineLangParser.VarUseExprContext ctx) {
        var fd = getScope(ctx);
        var slot = fd.find(ctx.ID().getText());
        if (slot.frameSlot() == null) {
            throw new VarNotFoundException(ctx);
        } else {
            return of(slot.frameDescriptor(), (slot.isGlobal() && !fd.isRoot() //如果本身就是全局的话，就使用一般读取变量节点以获取更高速度
                    ? GlobalVarReadNodeFactory.create(slot.frameSlot())
                    : LocalVarReadNodeFactory.create(slot.frameSlot()).setSourceSection(section(ctx))));
        }
    }

    @Override
    public VisitResult<?> visitVarSetExpr(MineLangParser.VarSetExprContext ctx) {
        var fd = getScope(ctx);
        var scopeFindResult = fd.directFind(ctx.ID().getText());
        var content = visit(scope(ctx.expr(), fd));
        var slot = scopeFindResult.frameSlot() == null ? fd.declare(ctx.ID().getText(), content) : scopeFindResult.frameSlot();
        return of(fd, (scopeFindResult.isGlobal() && !fd.isRoot() //如果本身就是全局的话，就使用一般读取变量节点以获取更高速度
                ? GlobalVarWriteNodeFactory.create(content.singleNode(), slot)
                : LocalVarWriteNodeFactory.create(content.singleNode(), slot)).setSourceSection(section(ctx)));
    }

    @Override
    public VisitResult<?> visitGlobalExpr(MineLangParser.GlobalExprContext ctx) {
        var fd = getScope(ctx);
        var ids = ctx.ID();
        fd.availableGlobals.addAll((ids.size() > ParallelThreshold ? ids.parallelStream() : ids.stream())
                .map(ParseTree::getText).collect(Collectors.toSet()));
        return of(NoneLiteralNodeFactory.create());
    }

    @Override
    public VisitResult<?> visitIfelseExpr(MineLangParser.IfelseExprContext ctx) {
        var fd = getScope(ctx);
        var exprs = ctx.expr();
        var len = exprs.size();
        var conditions = new MineNode[(len >> 1)];
        var branches = new MineNode[len - (len >> 1)];
        for (var i = 0; i < (len >> 1); i++) {
            conditions[i] = visit(scope(exprs.get(i << 1), fd)).singleNode();
            /*
             * 如果当前处理的分支是个代码块，就通知不要使用内部帧而是Ifelse节点提供的帧
             * 这样做是为了保留以后模式匹配等功能修改的空间
             */
            var brExpr = exprs.get((i << 1) + 1);
            if (brExpr instanceof MineLangParser.BlockExprContext blockExpr) {
                branches[i] = visitBlockExpr(scope(blockExpr, fd), false).singleNode();
            } else {
                branches[i] = visit(scope(brExpr, fd)).singleNode();
            }
        }
        // 处理最后一个else分支
        if ((len & 1) == 1) {
            var brExpr = exprs.get(len - 1);
            if (brExpr instanceof MineLangParser.BlockExprContext blockExpr) {
                branches[((len - 1) >> 1)] = visitBlockExpr(scope(blockExpr, fd), false).singleNode();
            } else {
                branches[((len - 1) >> 1)] = visit(scope(brExpr, fd)).singleNode();
            }
        }
        return of(IfElseNodeFactory.create(conditions, branches).setSourceSection(section(ctx)));
    }

    @Override
    public VisitResult<?> visitEndlessLoopExpr(MineLangParser.EndlessLoopExprContext ctx) {
        var fd = getScope(ctx);
        var expr = ctx.expr();
        var body = expr instanceof MineLangParser.BlockExprContext blockExprContext ?
                visitBlockExpr(scope(blockExprContext, fd), false).singleNode()
                : visit(scope(expr, fd)).singleNode();
        return of(EndlessLoopNodeFactory.create(body).setSourceSection(section(ctx)));
    }

    @Override
    public VisitResult<?> visitBreakExpr(MineLangParser.BreakExprContext ctx) {
        var fd = getScope(ctx);
        return of(BreakNodeFactory.create(ctx.expr() == null ? NoneLiteralNodeFactory.create()
                : visit(scope(ctx.expr(), fd)).singleNode()).setSourceSection(section(ctx)));
    }

    @Override
    public VisitResult<?> visitContinueExpr(MineLangParser.ContinueExprContext ctx) {
        return of(ContinueNodeFactory.create());
    }

    @Override
    public VisitResult<?> visitFuncDefineExpr(MineLangParser.FuncDefineExprContext ctx) {
        var fd = getScope(ctx);
        var ids = ctx.ID();
        var funcName = ids.remove(0).getText();
        var idNames = ids.stream().map(ParseTree::getText).toList();
        var scopeFindResult = fd.directFind(funcName);
        if (scopeFindResult.frameSlot() == null) fd.declare(funcName);
        var body = ctx.expr();

        VisitResult<?> bodyNodeVisitResult;
        if(body instanceof MineLangParser.BlockExprContext blockBody) {
            var blockFd = new FrameDescriptor(MineNone.SINGLETON);
            idNames.forEach(each -> blockFd.addFrameSlot(each, FrameSlotKind.Object));
            bodyNodeVisitResult = visitBlockExpr(scope(blockBody, fd), blockFd, false);
        } else {
            idNames.forEach(fd::declare);
            bodyNodeVisitResult = visit(scope(body, fd));
        }

        var funcDefineNode = FunctionDefineNodeFactory.create(
                (FunctionBodyNode) FunctionBodyNodeFactory.create(bodyNodeVisitResult.singleNode()).setSourceSection(section(body))
                , funcName, idNames.toArray(String[]::new)
        ).setSourceSection(section(ctx));
        return of(funcDefineNode);
    }

    @Override
    public VisitResult<?> visitFuncCallExpr(MineLangParser.FuncCallExprContext ctx) {
        var fd = getScope(ctx);
        var getFuncNode = visit(scope(ctx.expr(), fd)).singleNode();
        var argsNode = ctx.callArgs().expr().stream()
                .map(each -> visit(scope(each, fd)).singleNode()).toArray(MineNode[]::new);
        return of(FunctionCallNodeFactory.create(argsNode, getFuncNode).setSourceSection(section(ctx)));
    }

    @Override
    public VisitResult<?> visitReturnExpr(MineLangParser.ReturnExprContext ctx) {
        return of(ReturnNodeFactory.create(ctx.expr() == null ? NoneLiteralNodeFactory.create() :
                visit(scope(ctx.expr(), getScope(ctx))).singleNode()).setSourceSection(section(ctx)));
    }

    private SourceSection section(ParserRuleContext ctx) {
        var startIndex = ctx.getStart().getStartIndex();
        return this.truffleSource.createSection(startIndex, ctx.getStop().getStopIndex() - startIndex + 1);
    }

    /**
     * 记录解析树节点的语法作用域
     *
     * @param ctx             解析树节点
     * @param frameDescriptor 该节点的语法作用域
     * @param <t>             节点类型
     * @return 节点本身
     */
    private <t extends ParserRuleContext> t scope(t ctx, LexicalScope frameDescriptor) {
        lexicalScopes.put(ctx, frameDescriptor);
        return ctx;
    }

    private LexicalScope getScope(ParserRuleContext ctx) {
        return lexicalScopes.get(ctx);
    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }
}
