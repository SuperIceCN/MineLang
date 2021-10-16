package me.minelang.compiler.lang.types;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.TruffleObject;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.library.CachedLibrary;
import com.oracle.truffle.api.library.ExportLibrary;
import com.oracle.truffle.api.library.ExportMessage;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import me.minelang.compiler.lang.MineLanguage;

import static com.oracle.truffle.api.CompilerDirectives.shouldNotReachHere;

/**
 * 为了使其他工具或其他语言能够从该语言的角度对原始值或外来值具有一致的观点，需要使用语言概览。
 * 默认情况下，Integer或String等基本值的互操作解释不是特定于语言的。因此，此语言视图调用例程以普通方式打印这些值。
 * 需要注意的是，语言概览不会作为正常值通过解释器执行传递。它仅设计为工具的临时辅助对象。
 */
@ExportLibrary(value = InteropLibrary.class, delegateTo = "delegate")
@SuppressWarnings("static-method")
public final class MineLanguageView implements TruffleObject {

    final Object delegate;

    MineLanguageView(Object delegate) {
        this.delegate = delegate;
    }

    @ExportMessage
    boolean hasLanguage() {
        return true;
    }

    /*
     * 语言概览必须始终与为其创建的语言相关联。这允许工具获取原语或外来值，并创建在MineLang中对应的值。
     */
    @ExportMessage
    Class<? extends TruffleLanguage<?>> getLanguage() {
        return MineLanguage.class;
    }

    @ExportMessage
    @ExplodeLoop
    boolean hasMetaObject(@CachedLibrary("this.delegate") InteropLibrary interop) {
        /*
         * 我们使用isInstance方法来确定其中一个内置类型是否正确。如果是，那么我们可以在getMetaObject中提供一个元对象。
         * 互操作约定要求精确。由于语言视图仅为原语值和其他语言的值创建，因此MineLang本身的值直接实现has/getMetaObject。
         * 例如，MineBigInteger已与MineLang关联，因此将不再使用语言概览。
         */
        for (MineType type : MineType.PRECEDENCE) {
            if (type.isInstance(delegate, interop)) {
                return true;
            }
        }
        return false;
    }

    @ExportMessage
    @ExplodeLoop
    Object getMetaObject(@CachedLibrary("this.delegate") InteropLibrary interop) throws UnsupportedMessageException {
        /*
         * 同上，但返回具体元对象。
         */
        for (MineType type : MineType.PRECEDENCE) {
            if (type.isInstance(delegate, interop)) {
                return type;
            }
        }
        throw UnsupportedMessageException.create();
    }

    @ExportMessage
    @ExplodeLoop
    Object toDisplayString(@SuppressWarnings("unused") boolean allowSideEffects, @CachedLibrary("this.delegate") InteropLibrary interop) {
        for (MineType type : MineType.PRECEDENCE) {
            if (type.isInstance(this.delegate, interop)) {
                try {
                    /*
                     * 在这里，类型是一个部分求值常量，因为我们使用@ExplodeLoop。所以这个if-else级联应该在部分计算后折叠。
                     */
                    if (type == MineType.NUMBER) {
                        return longToString(interop.asLong(delegate));
                    } else if (type == MineType.BOOLEAN) {
                        return Boolean.toString(interop.asBoolean(delegate));
                    } else if (type == MineType.STRING) {
                        return interop.asString(delegate);
                    } else {
                        /* 如果都不是的话就返回名称 */
                        return type.getName();
                    }
                } catch (UnsupportedMessageException e) {
                    throw shouldNotReachHere(e);
                }
            }
        }
        return "Unsupported";
    }

    /*
     * Long.toString对于部分求值而言不安全，所以我们将其置于ast边界之外以避免bug。
     */
    @TruffleBoundary
    private static String longToString(long l) {
        return Long.toString(l);
    }

    public static Object create(Object value) {
        assert isPrimitiveOrFromOtherLanguage(value);
        return new MineLanguageView(value);
    }

    private static boolean isPrimitiveOrFromOtherLanguage(Object value) {
        InteropLibrary interop = InteropLibrary.getFactory().getUncached(value);
        try {
            return !interop.hasLanguage(value) || interop.getLanguage(value) != MineLanguage.class;
        } catch (UnsupportedMessageException e) {
            throw shouldNotReachHere(e);
        }
    }

    /**
     * 返回基本值或外来值的语言概览。
     * 为MineLang中的值返回相同的值。这对于在慢速路径中从MineLang的角度查看值非常有用。例如在错误消息中打印值。
     */
    @TruffleBoundary
    public static Object forValue(Object value) {
        if (value == null) {
            return null;
        }
        InteropLibrary lib = InteropLibrary.getFactory().getUncached(value);
        try {
            if (lib.hasLanguage(value) && lib.getLanguage(value) == MineLanguage.class) {
                return value;
            } else {
                return create(value);
            }
        } catch (UnsupportedMessageException e) {
            throw shouldNotReachHere(e);
        }
    }

}
