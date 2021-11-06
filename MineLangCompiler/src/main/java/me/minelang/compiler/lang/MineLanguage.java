package me.minelang.compiler.lang;

import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.nodes.Node;
import me.minelang.compiler.lang.nodes.MineNode;
import me.minelang.compiler.lang.nodes.MineRootNode;
import me.minelang.compiler.lang.runtime.initers.AbstractIniter;
import me.minelang.compiler.lang.runtime.initers.BuiltInFunctionIniter;
import me.minelang.compiler.lang.types.MineLanguageView;
import me.minelang.compiler.lang.types.MineNone;
import me.minelang.compiler.parser.MineLangASTBuilder;
import me.minelang.compiler.parser.MineLangLexer;
import me.minelang.compiler.parser.MineLangParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.util.ArrayList;
import java.util.List;

@TruffleLanguage.Registration(id = "MineLang", name = "MineLang")
public final class MineLanguage extends TruffleLanguage<MineContext> {
    private static final LanguageReference<MineLanguage> REFERENCE = LanguageReference.create(MineLanguage.class);

    public static MineLanguage get(Node node) {
        return REFERENCE.get(node);
    }

    public final List<AbstractIniter<?>> initers = new ArrayList<>(1);

    @Override
    protected MineContext createContext(Env env) {
        return new MineContext(this, env);
    }

    @Override
    protected Object getLanguageView(MineContext context, Object value) {
        return MineLanguageView.create(value);
    }

    @Override
    protected CallTarget parse(ParsingRequest request) {
        var rootFrameDescriptor = new FrameDescriptor(MineNone.SINGLETON);
        var sourceName = request.getSource().getName();
        var sourceContent = request.getSource().getCharacters().toString();
        var charStream = CharStreams.fromString(sourceContent, sourceName);
        var lexer = new MineLangLexer(charStream);
        var tokenStream = new CommonTokenStream(lexer);
        var parser = new MineLangParser(tokenStream);
        var program = parser.program();
        var astBuilder = new MineLangASTBuilder(sourceName, sourceContent, rootFrameDescriptor);
        var builtInFunctionIniter = new BuiltInFunctionIniter(astBuilder.rootLexicalScope, this);
        this.initers.add(builtInFunctionIniter);
        builtInFunctionIniter.declare();
        var buildResult = astBuilder.visit(program);

        var rootNode = new MineRootNode(this, buildResult.multiNode().toArray(new MineNode[0]), rootFrameDescriptor);
        return Truffle.getRuntime().createCallTarget(rootNode);
    }

    /**
     * 用于转储错误
     *
     * @param error 错误信息
     */
    public void err(String error) {
        // TODO: 2021/10/17 完善转储错误信息机制
        System.out.println(error);
    }
}
