package me.minelang.compiler.lang.types;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.TruffleObject;
import com.oracle.truffle.api.library.ExportLibrary;
import com.oracle.truffle.api.library.ExportMessage;
import com.oracle.truffle.api.utilities.TriState;
import me.minelang.compiler.lang.MineLanguage;

@ExportLibrary(InteropLibrary.class)
public final class MineUndefined implements TruffleObject {
    public static final MineUndefined SINGLETON = new MineUndefined();
    private static final int IDENTITY_HASH = System.identityHashCode(SINGLETON);

    private MineUndefined() {

    }

    @Override
    public String toString() {
        return "undefined";
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
        return MineType.UNDEFINED;
    }

    @ExportMessage
    static TriState isIdenticalOrUndefined(@SuppressWarnings("unused") MineUndefined receiver, Object other) {
        /*
         * 所有的Undefined都是一个对象。
         */
        return TriState.valueOf(MineUndefined.SINGLETON == other);
    }

    @ExportMessage
    static int identityHashCode(@SuppressWarnings("unused") MineUndefined receiver) {
        return IDENTITY_HASH;
    }

    @ExportMessage
    Object toDisplayString(@SuppressWarnings("unused") boolean allowSideEffects) {
        return "undefined";
    }
}
