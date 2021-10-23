package me.minelang.compiler.lang.exceptions;

import java.io.Serial;

public abstract class SpecialReturnException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -1881866337215151761L;

    public SpecialReturnException() {
        super(null, null);
    }
}
