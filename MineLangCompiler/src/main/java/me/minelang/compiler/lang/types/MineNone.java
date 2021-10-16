package me.minelang.compiler.lang.types;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.TruffleObject;
import com.oracle.truffle.api.library.ExportLibrary;
import com.oracle.truffle.api.library.ExportMessage;
import me.minelang.compiler.lang.MineLanguage;
import com.oracle.truffle.api.utilities.TriState;

@ExportLibrary(InteropLibrary.class)
public final class MineNone implements TruffleObject {
    public static final MineNone SINGLETON = new MineNone();
    private static final int IDENTITY_HASH = System.identityHashCode(SINGLETON);

    private MineNone() {

    }

    @Override
    public String toString() {
        return "None";
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
        return MineType.NONE;
    }

    @ExportMessage
    static TriState isIdenticalOrUndefined(@SuppressWarnings("unused") MineNone receiver, Object other) {
        /*
         * 所有的None都是一个对象。
         */
        return TriState.valueOf(MineNone.SINGLETON == other);
    }

    @ExportMessage
    static int identityHashCode(@SuppressWarnings("unused") MineNone receiver) {
        return IDENTITY_HASH;
    }

    @ExportMessage
    Object toDisplayString(@SuppressWarnings("unused") boolean allowSideEffects) {
        return "None";
    }
}
