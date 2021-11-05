package me.minelang.compiler.lang.exceptions.runtime;

import java.util.Arrays;

public final class ForeignFunctionCallFailedException extends MineLangRuntimeException{
    public ForeignFunctionCallFailedException(String name, Object[] args, int line, int column) {
        super("Failed to call foreign function %s with %s at line %d, column %d"
                .formatted(name, Arrays.toString(args), line, column));
    }
}
