package me.minelang.compiler.lang.nodes.control;

public record LoopStatus(boolean isNormalExit, Object result) {
    public static LoopStatus Continue = new LoopStatus(false, null);

    public boolean isRunning() {
        return this == Continue;
    }

    public boolean isNormalExit() {
        return !isRunning() && isNormalExit;
    }
}
