package me.minelang.compiler.lang.nodes.control;

import me.minelang.compiler.lang.nodes.MineNode;

public final class IfElseNodeFactory {
    public static IfElseNode create(MineNode[] conditions, MineNode[] branches) {
        return new IfElseNode(conditions, branches);
    }

    public static IfElseNode create(MineNode condition, MineNode... branches) {
        return new IfElseNode(new MineNode[]{condition}, branches);
    }
}
