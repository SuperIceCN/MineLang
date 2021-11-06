package me.minelang.compiler.lang.runtime.functions;

import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.nodes.RootNode;
import me.minelang.compiler.lang.MineLanguage;
import me.minelang.compiler.lang.types.MineFunction;

public abstract class BuiltInFunctionRootNode extends RootNode {
    private final String name;
    private final String[] args;
    protected BuiltInFunctionRootNode(MineLanguage language, String name, String... args) {
        super(language);
        this.name = name;
        this.args = args;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public MineFunction toMineFunction() {
        return new MineFunction(Truffle.getRuntime().createCallTarget(this)).setArgNames(args);
    }
}
