package me.minelang.compiler.parser.exceptions;

import org.antlr.v4.runtime.ParserRuleContext;

public final class VarNotFoundException extends ParseException {
    public VarNotFoundException(String varName, int line, int column) {
        super("Variable %s referred before declare at line %d, column %d.".formatted(varName, line, column));
    }

    public VarNotFoundException(ParserRuleContext varNode) {
        this(varNode.getText(), varNode.getStart().getLine(), varNode.getStart().getCharPositionInLine());
    }
}
