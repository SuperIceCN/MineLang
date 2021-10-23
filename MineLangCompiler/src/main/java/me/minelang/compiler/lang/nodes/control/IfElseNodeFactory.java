package me.minelang.compiler.lang.nodes.control;

import me.minelang.compiler.lang.nodes.MineNode;

public final class IfElseNodeFactory {
    public static IfElseNode create(MineNode[] conditions, BlockNode[] branches) {
        return new IfElseNode(conditions, branches);
    }

    public static IfElseNode create(MineNode condition, BlockNode... branches) {
        return new IfElseNode(new MineNode[]{condition}, branches);
    }
}
