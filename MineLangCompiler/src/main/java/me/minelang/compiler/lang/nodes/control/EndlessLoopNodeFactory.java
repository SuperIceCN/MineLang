package me.minelang.compiler.lang.nodes.control;

import me.minelang.compiler.lang.nodes.MineNode;

public final class EndlessLoopNodeFactory {
    public static EndlessLoopNode create(MineNode conditionNode, MineNode bodyNode, MineNode elseBlock) {
        return new EndlessLoopNode(conditionNode, bodyNode, elseBlock);
    }

    public static EndlessLoopNode create(MineNode conditionNode, MineNode bodyNode) {
        return new EndlessLoopNode(conditionNode, bodyNode, EmptyNodeFactory.create());
    }
}
