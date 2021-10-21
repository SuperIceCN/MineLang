package me.minelang.compiler.lang.exceptions;

public abstract class SpecialReturnException extends RuntimeException {
    public static final long serialVersionUID = -1881866337215151761L;

    public SpecialReturnException() {
        super(null, null);
    }
}
