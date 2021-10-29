package me.minelang.compiler.parser;

import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.source.Source;
import com.oracle.truffle.api.source.SourceSection;
import me.minelang.compiler.lang.nodes.MineNode;
import me.minelang.compiler.lang.nodes.control.BlockNodeFactory;
import me.minelang.compiler.lang.nodes.literial.LiteralNodeFactory;
import me.minelang.compiler.lang.nodes.literial.NanLiteralNodeFactory;
import me.minelang.compiler.lang.nodes.literial.NoneLiteralNodeFactory;
import me.minelang.compiler.lang.nodes.operator.*;
import me.minelang.compiler.lang.nodes.value.LocalVarReadNodeFactory;
import me.minelang.compiler.lang.nodes.value.LocalVarWriteNodeFactory;
import me.minelang.compiler.lang.types.MineNone;
import me.minelang.compiler.parser.exceptions.InvalidParseNodeException;
import me.minelang.compiler.parser.exceptions.VarNotFoundException;
import me.minelang.compiler.utils.StringUtil;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Objects;

import static me.minelang.compiler.parser.VisitResult.of;
import static me.minelang.compiler.parser.LexicalScope.of;

public class MineLangASTBuilder extends MineLangBaseVisitor<VisitResult<?>> {
    public final String sourceName;
    public final String sourceContent;
    public final Source truffleSource;

    public final ParseTreeProperty<LexicalScope> lexicalScopes = new ParseTreeProperty<>();
    public final LexicalScope rootLexicalScope;

    public MineLangASTBuilder(String sourceName, String sourceContent, FrameDescriptor rootFrameDescriptor) {
        this.sourceName = sourceName;
        this.sourceContent = sourceContent;
        this.rootLexicalScope = of(null, rootFrameDescriptor);
        this.truffleSource = Source.newBuilder("MineLang", sourceContent, sourceName)
                .encoding(StandardCharsets.UTF_8).build();
    }

    @Override
    public VisitResult<?> visitProgram(MineLangParser.ProgramContext ctx) {
        scope(ctx, rootLexicalScope);
        var nodes = new ArrayList<MineNode>();
        ctx.expr().forEach(exprContext -> nodes.add(visit(scope(exprContext, rootLexicalScope)).singleNode()));
        return of(nodes);
    }

    @Override
    public VisitResult<?> visitBlockExpr(MineLangParser.BlockExprContext ctx) {
        var nodes = new ArrayList<MineNode>();
        var fd = of(getScope(ctx), new FrameDescriptor(MineNone.SINGLETON));
        ctx.expr().forEach(exprContext -> nodes.add(visit(scope(exprContext, fd)).singleNode()));
        return of(BlockNodeFactory.create(fd.getFrameDescriptor(), nodes.toArray(new MineNode[]{}))
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
        if (slot == null) {
            throw new VarNotFoundException(ctx);
        }else {
            return of(slot.frameDescriptor(), LocalVarReadNodeFactory.create(slot.frameSlot()));
        }
    }

    @Override
    public VisitResult<?> visitVarSetExpr(MineLangParser.VarSetExprContext ctx) {
        var fd = getScope(ctx);
        var slot = Objects.requireNonNull(fd.directFind(ctx.ID().getText())).frameSlot();
        var content = visit(scope(ctx.expr(), fd));
        if (slot == null) {
            slot = fd.declare(ctx.ID().getText(), content);
        }
        return of(fd, LocalVarWriteNodeFactory.create(content.singleNode(), slot));
    }

    private SourceSection section(ParserRuleContext ctx) {
        var startIndex = ctx.getStart().getStartIndex();
        return this.truffleSource.createSection(startIndex, ctx.getStop().getStopIndex() - startIndex);
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
}
