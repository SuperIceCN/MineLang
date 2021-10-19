package me.minelang.compiler.lang.nodes.operator;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.dsl.Fallback;
import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;
import me.minelang.compiler.lang.nodes.MineNode;
import me.minelang.compiler.lang.types.MineBigDecimal;
import me.minelang.compiler.lang.types.MineBigInteger;
import me.minelang.compiler.lang.types.MineNone;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

@NodeInfo(language = "MineLang", shortName = "/", description = "operatorDivide")
@NodeChild(value = "left", type = MineNode.class)
@NodeChild(value = "right", type = MineNode.class)
public abstract class DivideOperatorNode extends AbstractOperatorNode {

    @Specialization(guards = "b != 0")
    byte getBytes(byte a, byte b) {
        return (byte) (a / b);
    }

    @Specialization(guards = "b != 0")
    short getShorts(short a, short b) {
        return (short) (a / b);
    }

    @Specialization(guards = "b != 0")
    int getInts(int a, int b) {
        return a / b;
    }

    @Specialization(guards = "b != 0")
    long getLongs(long a, long b) {
        return a / b;
    }

    @Specialization(guards = "notZero(b)")
    MineBigInteger getBigIntegers(MineBigInteger a, MineBigInteger b) {
        return new MineBigInteger(a.getValue().multiply(b.getValue()));
    }

    @Specialization(rewriteOn = ArithmeticException.class, guards = "notZero(b)")
    float getFloats(float a, float b) {
        var x = a / b;
        if (x >= -Float.MAX_VALUE || x <= Float.MAX_VALUE) {
            return x;
        } else {
            throw new ArithmeticException("float overflow");
        }
    }

    @Specialization(rewriteOn = ArithmeticException.class, guards = "notZero(b)")
    double getDoubles(double a, double b) {
        var x = a / b;
        if (x >= -Double.MAX_VALUE || x <= Double.MAX_VALUE) {
            return x;
        } else {
            throw new ArithmeticException("double overflow");
        }
    }

    @Specialization(guards = "notZero(b)")
    MineBigDecimal getBigDecimals(MineBigDecimal a, MineBigDecimal b) {
        return new MineBigDecimal(a.getValue().divide(b.getValue(), RoundingMode.HALF_UP));
    }

    /**
     * 如果除法出错，就返回None
     */
    @Fallback
    @SuppressWarnings("unused")
    Object get(Object a, Object b){
        return MineNone.SINGLETON;
    }

    @CompilerDirectives.TruffleBoundary(allowInlining = true)
    boolean notZero(float v){
        return v != 0f;
    }

    @CompilerDirectives.TruffleBoundary(allowInlining = true)
    boolean notZero(double v){
        return v != 0d;
    }

    @CompilerDirectives.TruffleBoundary(allowInlining = true)
    boolean notZero(MineBigInteger v){
        return !v.getValue().equals(BigInteger.ZERO);
    }

    @CompilerDirectives.TruffleBoundary(allowInlining = true)
    boolean notZero(MineBigDecimal v){
        return !v.getValue().equals(BigDecimal.ZERO);
    }
}
