package me.minelang.compiler.lang.types;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.TruffleObject;
import com.oracle.truffle.api.library.ExportLibrary;
import com.oracle.truffle.api.library.ExportMessage;
import com.oracle.truffle.api.utilities.TriState;
import me.minelang.compiler.lang.MineLanguage;

@ExportLibrary(InteropLibrary.class)
public final class MineNan implements TruffleObject {
    public static final MineNan SINGLETON = new MineNan();
    private static final int IDENTITY_HASH = System.identityHashCode(SINGLETON);

    private MineNan() {

    }

    @Override
    public String toString() {
        return "Nan";
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
    boolean isNull() {
        return true;
    }

    @ExportMessage
    boolean hasMetaObject() {
        return true;
    }

    @ExportMessage
    Object getMetaObject() {
        return MineType.NAN;
    }

    @ExportMessage
    static TriState isIdenticalOrUndefined(@SuppressWarnings("unused") MineNan receiver, Object other) {
        /*
         * 所有的Nan都是一个对象。
         */
        return TriState.valueOf(MineNan.SINGLETON == other);
    }

    @ExportMessage
    static int identityHashCode(@SuppressWarnings("unused") MineNan receiver) {
        return IDENTITY_HASH;
    }

    @ExportMessage
    Object toDisplayString(@SuppressWarnings("unused") boolean allowSideEffects) {
        return "Nan";
    }
}
