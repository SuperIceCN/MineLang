package me.minelang.compiler.lang.exceptions.runtime;

import java.util.Arrays;

public final class InvalidFunctionArgsException extends MineLangRuntimeException{
    public InvalidFunctionArgsException(String name, String[] args, Object[] values, int line, int column) {
        super("%s can't be applied to function %s which requires args %s at line %d, column %d"
                .formatted(Arrays.toString(values), name, Arrays.toString(args), line, column));
    }
}
