package me.minelang.compiler.lang.exceptions.runtime;

import me.minelang.compiler.lang.nodes.value.AbstractVarNode;

public final class GlobalVarNotFoundException extends MineLangRuntimeException {
    public GlobalVarNotFoundException(String varName, int line, int column) {
        super("Global variable %s referred before being declared at line %d, column %d.".formatted(varName, line, column));
    }

    public GlobalVarNotFoundException(AbstractVarNode node){
        this(node.toString(), node.getSourceSection().getStartLine(), node.getSourceSection().getStartColumn());
    }
}
