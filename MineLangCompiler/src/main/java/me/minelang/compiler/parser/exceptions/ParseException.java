package me.minelang.compiler.parser.exceptions;

public abstract class ParseException extends RuntimeException{
    public ParseException(String message) {
        super(message);
    }
}
