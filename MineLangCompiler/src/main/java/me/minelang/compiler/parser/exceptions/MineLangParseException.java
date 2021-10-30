package me.minelang.compiler.parser.exceptions;

public abstract class MineLangParseException extends RuntimeException{
    public MineLangParseException(String message) {
        super(message);
    }
}
