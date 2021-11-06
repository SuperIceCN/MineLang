package me.minelang.compiler.lang.runtime.initers;

import me.minelang.compiler.lang.MineLanguage;
import me.minelang.compiler.lang.runtime.functions.BuiltInFunctionRootNode;
import me.minelang.compiler.lang.runtime.functions.PrintFunctionRootNode;
import me.minelang.compiler.parser.LexicalScope;

public final class BuiltInFunctionIniter extends AbstractIniter<BuiltInFunctionRootNode>{
    public BuiltInFunctionIniter(LexicalScope globalScope, MineLanguage language) {
        super(globalScope, language);
    }

    @Override
    protected void initDeclare() {
        this.addDeclare("print", new PrintFunctionRootNode(this.language));
    }

    @Override
    protected Function processDeclare(String name, BuiltInFunctionRootNode builtInFunctionRootNode) {
        return new Function(name, builtInFunctionRootNode.toMineFunction());
    }
}
