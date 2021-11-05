package me.minelang.compiler.lang.nodes.function;

import me.minelang.compiler.lang.nodes.MineNode;

public final class FunctionBodyNodeFactory {
    public static FunctionBodyNode create(MineNode bodyNode) {
        return new FunctionBodyNode(bodyNode);
    }
}
