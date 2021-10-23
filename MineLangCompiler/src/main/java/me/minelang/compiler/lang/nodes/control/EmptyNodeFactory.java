package me.minelang.compiler.lang.nodes.control;

public final class EmptyNodeFactory {
    private static final EmptyNode SINGLETON = new EmptyNode();

    public static EmptyNode create() {
        return SINGLETON;
    }
}
