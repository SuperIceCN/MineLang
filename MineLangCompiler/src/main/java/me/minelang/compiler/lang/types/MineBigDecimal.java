package me.minelang.compiler.lang.types;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.TruffleObject;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.library.ExportLibrary;
import com.oracle.truffle.api.library.ExportMessage;
import me.minelang.compiler.lang.MineLanguage;

import java.math.BigDecimal;
import java.math.BigInteger;

@ExportLibrary(InteropLibrary.class)
@SuppressWarnings("unused")
public final class MineBigDecimal implements TruffleObject, Comparable<MineBigDecimal> {
    private static final BigDecimal DOUBLE_MAX = BigDecimal.valueOf(Double.MAX_VALUE);
    private static final BigDecimal DOUBLE_MIN = BigDecimal.valueOf(Double.MIN_VALUE);
    private static final BigDecimal FLOAT_MAX = BigDecimal.valueOf(Float.MAX_VALUE);
    private static final BigDecimal FLOAT_MIN = BigDecimal.valueOf(Float.MIN_VALUE);

    private final BigDecimal value;

    public MineBigDecimal(BigDecimal value) {
        this.value = value;
    }

    public MineBigDecimal(double value) {
        this.value = BigDecimal.valueOf(value);
    }

    public MineBigDecimal(BigInteger value) {
        this.value = new BigDecimal(value);
    }

    public BigDecimal getValue() {
        return value;
    }

    @CompilerDirectives.TruffleBoundary
    public int compareTo(MineBigDecimal o) {
        return value.compareTo(o.getValue());
    }

    @Override
    @CompilerDirectives.TruffleBoundary
    public String toString() {
        return value.toString();
    }

    @Override
    @CompilerDirectives.TruffleBoundary
    public boolean equals(Object obj) {
        if (obj instanceof MineBigDecimal o) {
            return value.equals(o.getValue());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @SuppressWarnings("static-method")
    @ExportMessage
    boolean isNumber() {
        return fitsInDouble();
    }

    @ExportMessage
    @CompilerDirectives.TruffleBoundary
    boolean fitsInDouble() {
        return value.compareTo(DOUBLE_MAX) <= 0 && value.compareTo(DOUBLE_MIN) >= 0;
    }

    @ExportMessage
    @CompilerDirectives.TruffleBoundary
    float asFloat() throws UnsupportedMessageException {
        if (fitsInFloat()) {
            return value.floatValue();
        } else {
            throw UnsupportedMessageException.create();
        }
    }

    @ExportMessage
    boolean fitsInByte() {
        return false;
    }

    @ExportMessage
    boolean fitsInShort() {
        return false;
    }

    @ExportMessage
    boolean fitsInInt() {
        return false;
    }

    @ExportMessage
    boolean fitsInLong() {
        return false;
    }

    @ExportMessage
    boolean fitsInFloat() {
        return value.compareTo(FLOAT_MAX) <= 0 && value.compareTo(FLOAT_MIN) >= 0;
    }

    @ExportMessage
    @CompilerDirectives.TruffleBoundary
    double asDouble() throws UnsupportedMessageException {
        if (fitsInDouble()) {
            return value.doubleValue();
        } else {
            throw UnsupportedMessageException.create();
        }
    }

    @ExportMessage
    byte asByte() throws UnsupportedMessageException {
        throw UnsupportedMessageException.create();
    }

    @ExportMessage
    short asShort() throws UnsupportedMessageException {
        throw UnsupportedMessageException.create();
    }

    @ExportMessage
    int asInt() throws UnsupportedMessageException {
        throw UnsupportedMessageException.create();
    }

    @ExportMessage
    long asLong() throws UnsupportedMessageException {
        throw UnsupportedMessageException.create();
    }

    @ExportMessage
    boolean hasLanguage() {
        return true;
    }

    @ExportMessage
    Class<? extends TruffleLanguage<?>> getLanguage() {
        return MineLanguage.class;
    }

    @ExportMessage
    boolean hasMetaObject() {
        return true;
    }

    @ExportMessage
    Object getMetaObject() {
        return MineType.NUMBER;
    }

    @ExportMessage
    @CompilerDirectives.TruffleBoundary
    Object toDisplayString(@SuppressWarnings("unused") boolean allowSideEffects) {
        return value.toString();
    }
}
