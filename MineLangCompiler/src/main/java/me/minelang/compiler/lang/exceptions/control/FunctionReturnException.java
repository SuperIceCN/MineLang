package me.minelang.compiler.lang.exceptions.control;

import com.oracle.truffle.api.nodes.ControlFlowException;
import me.minelang.compiler.lang.types.MineNone;

import java.io.Serial;

public final class FunctionReturnException extends ControlFlowException {
    @Serial
    private static final long serialVersionUID = -9195384461112954365L;
    public static final FunctionReturnException SINGLETON = new FunctionReturnException(MineNone.SINGLETON);

    private final Object returnValue;

    private FunctionReturnException(Object returnValue) {
        this.returnValue = returnValue;
    }

    public Object getReturnValue() {
        return returnValue;
    }

    public static FunctionReturnException create(Object returnValue) {
        if (returnValue == MineNone.SINGLETON) {
            return SINGLETON;
        } else {
            return new FunctionReturnException(returnValue);
        }
    }

    public static FunctionReturnException create() {
        return SINGLETON;
    }
}
