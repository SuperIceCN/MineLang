package me.minelang.compiler.lang.exceptions.runtime;

public abstract class MineLangRuntimeException extends RuntimeException {
    public MineLangRuntimeException(String message) {
        super(message);
    }
}
