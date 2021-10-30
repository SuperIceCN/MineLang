package me.minelang.compiler.lang.types;

import com.oracle.truffle.api.interop.TruffleObject;

import com.oracle.truffle.api.CompilerAsserts;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.dsl.Cached;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.library.CachedLibrary;
import com.oracle.truffle.api.library.ExportLibrary;
import com.oracle.truffle.api.library.ExportMessage;
import me.minelang.compiler.lang.MineLanguage;

/**
 * 这里是MineLang的自带类型定义。当前阶段实现暂未考虑创建其他类型，如{@code type}关键字定义等。
 *
 * {@link this.isInstance(Object, InteropLibrary)}所检查的每一个类型的逻辑都使用一个函数接口封装，当前它们的逻辑
 * 是使用interoperability互操作库中的检查函数。 {@// TODO: 2021/10/11 进行拓展并优化性能 }
 * 之所以要这么做，是因为外部语言，如js、java、python在与MineLang交互的时候就可以自动对一等值进行检查并确认种类以便优化
 *
 * 该类实现了{@link InteropLibrary}库中的互操作约定（{@link InteropLibrary#isMetaObject(Object)}、{@link InteropLibrary#isMetaInstance(Object, Object)}），
 * 这使得其他语言和第三方（或许以后会有自带的）工具能够通过interoperability互操作库对MineLang进行类型检查，
 * 其中，{@code MetaObject}是描述一个值的类型的对象，类似于java中的Class对象或者js中的原型链。
 *
 * 为了让其他语言能确认值的种类，每个值类都必须实现{@link InteropLibrary#getMetaObject(Object)}。
 * 但很显然基本类型，如byte、int并不能在内部实现互操作约定中的getMetaObject，所以需要我们通过LanguageView，
 * 即语言概览来实现。参阅{@link MineLanguageView}。
 */
@ExportLibrary(InteropLibrary.class)
@SuppressWarnings("static-method")
public final class MineType implements TruffleObject {

    /*
     * 这里是自带类型的元对象常量，可能以后会有更多，此处未考虑自定义类型
     */
    public static final MineType NUMBER = new MineType("Number", (l, v) -> l.isNumber(v) || v instanceof MineBigInteger || v instanceof MineBigDecimal);
    public static final MineType NONE = new MineType("None", InteropLibrary::isNull);
    public static final MineType NAN = new MineType("Nan", (l, v) -> {
        if(v == MineNan.SINGLETON) return true;
        else if(v instanceof Float f) return Float.isNaN(f);
        else if(v instanceof Double d) return Double.isNaN(d);
        return false;
    });
    public static final MineType STRING = new MineType("String", InteropLibrary::isString);
    public static final MineType BOOLEAN = new MineType("Boolean", InteropLibrary::isBoolean);
    public static final MineType FUNCTION = new MineType("Function", InteropLibrary::isExecutable);
    public static final MineType OBJECT = new MineType("Object", InteropLibrary::hasMembers);

    /*
     * 此数组用来确定语言概览中对一个对象进行检查的顺序，特殊的是，暂时我们并不将函数认为是一个对象，以后会考虑修改
     * TODO: 2021/10/12 考虑将函数作为对象的可行性
     */
    @CompilationFinal(dimensions = 1)
    public static final MineType[] PRECEDENCE = new MineType[]{NONE, NAN, BOOLEAN, NUMBER, STRING, FUNCTION, OBJECT};

    private final String name;
    private final TypeCheck isInstance;

    /*
     * 因为暂时我们并不想考虑动态对象，所以静态的实例足够用了，无需公开构造函数
     */
    private MineType(String name, TypeCheck isInstance) {
        this.name = name;
        this.isInstance = isInstance;
    }

    /**
     * 检查某个值是否是此元对象标定的类型。
     */
    public boolean isInstance(Object value, InteropLibrary interop) {
        CompilerAsserts.partialEvaluationConstant(this);
        return isInstance.check(interop, value);
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
    boolean isMetaObject() {
        return true;
    }

    /*
     * 暂不区分完备名与简易名
     * TODO 2021/10/13 区分完备名与简易名
     */
    @ExportMessage(name = "getMetaQualifiedName")
    @ExportMessage(name = "getMetaSimpleName")
    public Object getName() {
        return name;
    }

    @ExportMessage(name = "toDisplayString")
    Object toDisplayString(@SuppressWarnings("unused") boolean allowSideEffects) {
        return name;
    }

    @Override
    public String toString() {
        return "MineType[" + name + "]";
    }

    /*
     * 此互操作函数将被用作其他语言或内建类型检查。它检查给出的值是否是基本类型，外来类型或内建类型。
     * 这将使得其他语言将可以判断MineLang的值的类型。
     */
    @ExportMessage
    static class IsMetaInstance {

        /*
         * 我们假设在源位置检查相同的类型。因此，我们使用内联缓存将观察到的类型专门化为常量。
         * “3”的限制指定我们专门处理3种不同的类型，直到我们重写为doGeneric情况。
         * 本例中的限制有些武断，应使用实际基准仔细调整来确定。
         */
        @Specialization(guards = "type == cachedType", limit = "3")
        static boolean doCached(@SuppressWarnings("unused") MineType type, Object value,
                                @Cached("type") MineType cachedType,
                                @CachedLibrary("value") InteropLibrary valueLib) {
            return cachedType.isInstance.check(valueLib, value);
        }

        @TruffleBoundary
        @Specialization(replaces = "doCached")
        static boolean doGeneric(MineType type, Object value) {
            return type.isInstance.check(InteropLibrary.getFactory().getUncached(), value);
        }
    }

    /**
     * 类型检查逻辑的函数式封装接口
     */
    @FunctionalInterface
    interface TypeCheck {
        boolean check(InteropLibrary lib, Object value);
    }

}
