package me.minelang.compiler.lang.nodes.control;

import me.minelang.compiler.lang.nodes.MineNode;

public final class EndlessLoopNodeFactory {
    public static EndlessLoopNode create(MineNode bodyNode) {
        return new EndlessLoopNode(bodyNode);
    }
}
