package me.minelang.compiler.lang.exceptions.control;

import com.oracle.truffle.api.nodes.ControlFlowException;

import java.io.Serial;

public final class LoopContinueException extends ControlFlowException {
    @Serial
    private static final long serialVersionUID = -2011980140053310274L;

    public static final LoopContinueException SINGLETON = new LoopContinueException();

    private LoopContinueException(){

    }

    public static LoopContinueException create() {
        return SINGLETON;
    }
}
