package me.minelang.compiler.lang.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.api.nodes.RootNode;
import com.oracle.truffle.api.source.SourceSection;
import me.minelang.compiler.lang.MineLanguage;
import me.minelang.compiler.lang.nodes.function.FunctionBodyNode;

@NodeInfo(language = "MineLang", shortName = "functionExec", description = "Execute a function.")
public final class MineFunctionRootNode extends RootNode {
    @Child
    FunctionBodyNode funcBody;
    private final VirtualFrame declareFrame;
    private final String name;
    private final String[] argNames;
    private final SourceSection sourceSection;

    public MineFunctionRootNode(MineLanguage language, VirtualFrame declareFrame, String name, String[] argNames, SourceSection sourceSection, FunctionBodyNode bodyNode) {
        super(language);
        this.declareFrame = declareFrame;
        this.funcBody = bodyNode;
        this.name = name;
        this.argNames = argNames;
        this.sourceSection = sourceSection;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        return funcBody.setArgNames(argNames).setArgValues(frame.getArguments()).execute(declareFrame);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public SourceSection getSourceSection() {
        return this.sourceSection;
    }
}
