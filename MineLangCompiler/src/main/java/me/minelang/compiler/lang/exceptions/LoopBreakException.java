package me.minelang.compiler.lang.exceptions;

import com.oracle.truffle.api.nodes.ControlFlowException;

import java.io.Serial;

public final class LoopBreakException extends ControlFlowException {
    @Serial
    private static final long serialVersionUID = -8562545277317690467L;
    public static final LoopBreakException SINGLETON = new LoopBreakException();

    private LoopBreakException() {

    }

    public static LoopBreakException create() {
        return SINGLETON;
    }

}
