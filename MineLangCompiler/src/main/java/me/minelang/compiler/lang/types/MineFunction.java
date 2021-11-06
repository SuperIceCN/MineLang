package me.minelang.compiler.lang.types;

import com.oracle.truffle.api.*;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.Cached;
import com.oracle.truffle.api.dsl.Fallback;
import com.oracle.truffle.api.dsl.ReportPolymorphism;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.interop.ArityException;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.TruffleObject;
import com.oracle.truffle.api.library.ExportLibrary;
import com.oracle.truffle.api.library.ExportMessage;
import com.oracle.truffle.api.nodes.DirectCallNode;
import com.oracle.truffle.api.nodes.IndirectCallNode;
import com.oracle.truffle.api.source.SourceSection;
import com.oracle.truffle.api.utilities.CyclicAssumption;
import com.oracle.truffle.api.utilities.TriState;
import me.minelang.compiler.lang.MineLanguage;
import me.minelang.compiler.lang.nodes.MineFunctionRootNode;

import java.util.Arrays;

@ExportLibrary(InteropLibrary.class)
@SuppressWarnings("static-method")
public final class MineFunction implements TruffleObject {
    /**
     * 内联缓存大小，特化后的函数可以内联以消除调用的开销
     * 尚不清楚多少的内联缓存限制是合适的，暂定为8，需要更多测试以确定
     *
     * @// TODO: 2021/11/3 测试到底内联缓存多大最合适
     */
    public static final int INLINE_CACHE_SIZE = 8;

    private final String name;
    @CompilationFinal
    private String[] argNames = new String[0];
    private RootCallTarget callTarget;
    /**
     * 管理 {@link #callTarget} 是否稳定的推断管理器。
     * {@link CyclicAssumption} 是一个可以自动管理 {@link Assumption} 的东西，
     * 当先前的推断失效时会自动更新推断。
     */
    private final CyclicAssumption callTargetStable;

    public MineFunction(RootCallTarget callTarget) {
        this.name = callTarget.getRootNode().getName();
        this.callTargetStable = new CyclicAssumption(name);
        setCallTarget(callTarget);
    }

    public MineFunction(MineFunctionRootNode rootNode) {
        this(Truffle.getRuntime().createCallTarget(rootNode));
    }

    public String getName() {
        return name;
    }

    public String[] getArgNames() {
        return argNames;
    }

    public MineFunction setArgNames(String[] argNames) {
        this.argNames = argNames;
        return this;
    }

    void setCallTarget(RootCallTarget callTarget) {
        var wasNull = this.callTarget == null;
        this.callTarget = callTarget;
        // 因为被设置了新的调用对象，所以旧的调用对象应当被抛弃。
        if (!wasNull) {
            callTargetStable.invalidate();
        }
    }

    public RootCallTarget getCallTarget() {
        return callTarget;
    }

    public Assumption getCallTargetStable() {
        return callTargetStable.getAssumption();
    }

    @Override
    public String toString() {
        var sig = Arrays.toString(getArgNames());
        return "function " + name + "(" + sig.substring(1, sig.length() - 1) + ")";
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
    boolean hasSourceLocation() {
        return true;
    }

    /**
     * {@link MineFunction} 对象不应当直接对外暴露
     */
    @ExportMessage
    @CompilerDirectives.TruffleBoundary
    SourceSection getSourceLocation() {
        return getCallTarget().getRootNode().getSourceSection();
    }

    /**
     * {@link MineFunction} 对象应当作为可执行目标对外暴露
     */
    @ExportMessage
    boolean isExecutable() {
        return true;
    }

    @ExportMessage
    boolean hasMetaObject() {
        return true;
    }

    @ExportMessage
    Object getMetaObject() {
        return MineType.FUNCTION;
    }

    @ExportMessage
    @SuppressWarnings("unused")
    static final class IsIdenticalOrUndefined {
        @Specialization
        static TriState doSLFunction(MineFunction receiver, MineFunction other) {
            // 函数对象应当永远不可能有相同的复制品，所以直接比较引用是否相等即可
            return receiver == other ? TriState.TRUE : TriState.FALSE;
        }

        @Fallback
        static TriState doOther(MineFunction receiver, Object other) {
            return TriState.UNDEFINED;
        }
    }

    @ExportMessage
    @CompilerDirectives.TruffleBoundary
    static int identityHashCode(MineFunction receiver) {
        return System.identityHashCode(receiver);
    }

    @ExportMessage
    Object toDisplayString(@SuppressWarnings("unused") boolean allowSideEffects) {
        return this.toString();
    }

    /**
     * 此类允许其他语言执行这个函数。我们实现了转发给函数分派的互操作执行库。
     * 由于调用可能造成极大开销（可能触发间接调用，间接调用本身很昂贵，而且也会限制函数内联，从而妨碍其他优化），
     * 如果节点变形（即超过缓存限制），我们使用的 {@link ReportPolymorphism} 注解将会发挥作用。
     * 这确保在该节点变为多态时通知运行时。在某些情况下，这反过来可能导致运行时通过复制包含该节点的整个AST并将其专门用于特定函数调用，
     * 并导致再次尝试使节点单态化。
     */
    @ReportPolymorphism
    @ExportMessage
    abstract static class Execute {

        /**
         * 函数执行的内联特化版本。
         *
         * <p>
         * {@code limit = "INLINE_CACHE_SIZE"} 内联缓存大小，特化后的函数可以内联以消除调用的开销
         * </p>
         * <p>
         * {@code guards = "function.getCallTarget() == cachedTarget"} 内联检验。
         * （cachedTarget是编译常量所以这玩意会被直接优化jit掉）
         * </p>
         * <p>
         * {@code assumptions = "callTargetStable"} 这里支持函数重定义。当函数被重新定义时，函数对象维护的调用目标被改变。
         * 为了避免对此进行检查，我们使用了一个假设，该假设在执行更改时使函数失效。
         * 由于在编译代码中检查假设是不可操作的，因此DSL执行的假设检查在优化执行期间不会增加任何开销。
         * </p>
         *
         * @param function         动态提供的函数对象
         * @param arguments        函数的参数~~
         * @param callTargetStable 函数未被重定义的断言
         * @param cachedTarget     目标调用对象
         * @param callNode         the {@link DirectCallNode} 在内联缓存调用目标 {@link CallTarget} 中生成的直接调用节点
         * @see Cached
         * @see Specialization
         */
        @Specialization(limit = "INLINE_CACHE_SIZE",
                guards = "function.getCallTarget() == cachedTarget",
                assumptions = "callTargetStable")
        @SuppressWarnings("unused")
        protected static Object doDirect(MineFunction function, Object[] arguments,
                                         @Cached("function.getCallTargetStable()") Assumption callTargetStable,
                                         @Cached("function.getCallTarget()") RootCallTarget cachedTarget,
                                         @Cached("create(cachedTarget)") DirectCallNode callNode) throws ArityException {

            // 内联缓存命中，我们可以直接进行重复调用，但是参数个数检查不能少
            final var len = function.argNames.length;
            if (len != arguments.length) {
                throw ArityException.create(len, len, arguments.length);
            }
            return callNode.call(arguments);
        }

        /**
         * 调用的慢路径代码，当多态内联缓存超过内联缓存大小中指定的最大大小时使用。此处的调用没有进一步优化，例如，没有执行方法内联。
         */
        @Specialization(replaces = "doDirect")
        protected static Object doIndirect(MineFunction function, Object[] arguments,
                                           @Cached IndirectCallNode callNode) throws ArityException {
            /*
             * 貌似直接call就完事了，以后完善了自定义类的时候或许需要更复杂的逻辑
             * 当然我们得检查一下参数个数对不对
             */
            final var len = function.argNames.length;
            if (len != arguments.length) {
                throw ArityException.create(len, len, arguments.length);
            }
            return callNode.call(function.getCallTarget(), arguments);
        }
    }
}
