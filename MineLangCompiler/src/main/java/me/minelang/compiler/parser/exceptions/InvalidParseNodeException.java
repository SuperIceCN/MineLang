package me.minelang.compiler.parser.exceptions;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

public final class InvalidParseNodeException extends ParseException{
    public final ParseTree invalidNode;

    public InvalidParseNodeException(ParseTree invalidNode, int line, int column) {
        super("Invalid parse node at line %d, column %d.".formatted(line, column));
        this.invalidNode = invalidNode;
    }

    public InvalidParseNodeException(ParserRuleContext invalidNode) {
        this(invalidNode, invalidNode.getStart().getLine(), invalidNode.getStart().getCharPositionInLine());
    }

    public ParseTree getInvalidNode() {
        return invalidNode;
    }
}
