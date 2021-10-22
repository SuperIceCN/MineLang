package me.minelang.compiler.lang.nodes.operator;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.dsl.Fallback;
import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;
import me.minelang.compiler.lang.nodes.MineNode;
import me.minelang.compiler.lang.types.MineBigDecimal;
import me.minelang.compiler.lang.types.MineBigInteger;
import me.minelang.compiler.lang.types.MineNan;

import java.math.BigDecimal;
import java.math.BigInteger;

@NodeInfo(language = "MineLang", shortName = "%", description = "operatorRemain")
@NodeChild(value = "left", type = MineNode.class)
@NodeChild(value = "right", type = MineNode.class)
public abstract class RemainOperatorNode extends AbstractOperatorNode {

    @Specialization(guards = "b == 0")
    MineNan nanBytes(byte a, byte b) {
        return MineNan.SINGLETON;
    }

    @Specialization(replaces = "nanBytes")
    byte getBytes(byte a, byte b) {
        return (byte) (a % b);
    }

    @Specialization(guards = "b == 0")
    MineNan nanShorts(short a, short b) {
        return MineNan.SINGLETON;
    }

    @Specialization(replaces = "nanShorts")
    short getShorts(short a, short b) {
        return (short) (a % b);
    }

    @Specialization(guards = "b == 0")
    MineNan nanInts(int a, int b) {
        return MineNan.SINGLETON;
    }

    @Specialization(replaces = "nanInts")
    int getInts(int a, int b) {
        return a % b;
    }

    @Specialization(guards = "b == 0")
    MineNan nanLongs(long a, long b) {
        return MineNan.SINGLETON;
    }

    @Specialization(replaces = "nanLongs")
    long getLongs(long a, long b) {
        return a % b;
    }

    @Specialization(guards = "!notZeroBI(b)")
    MineNan nanBigIntegers(MineBigInteger a, MineBigInteger b) {
        return MineNan.SINGLETON;
    }

    @Specialization(replaces = "nanBigIntegers")
    MineBigInteger getBigIntegers(MineBigInteger a, MineBigInteger b) {
        return new MineBigInteger(a.getValue().remainder(b.getValue()));
    }

    @Specialization(guards = "!notZeroF(b)")
    MineNan nanFloats(float a, float b) {
        return MineNan.SINGLETON;
    }

    @Specialization(rewriteOn = ArithmeticException.class, replaces = "nanFloats")
    float getFloats(float a, float b) {
        var x = a % b;
        if (x >= -Float.MAX_VALUE || x <= Float.MAX_VALUE) {
            return x;
        } else {
            throw new ArithmeticException("float overflow");
        }
    }

    @Specialization(guards = "!notZeroD(b)")
    MineNan nanDoubles(double a, double b) {
        return MineNan.SINGLETON;
    }

    @Specialization(rewriteOn = ArithmeticException.class, replaces = "nanDoubles")
    double getDoubles(double a, double b) {
        var x = a % b;
        if (x >= -Double.MAX_VALUE || x <= Double.MAX_VALUE) {
            return x;
        } else {
            throw new ArithmeticException("double overflow");
        }
    }

    @Specialization(guards = "!notZeroBD(b)")
    MineNan nanBigDecimals(MineBigDecimal a, MineBigDecimal b) {
        return MineNan.SINGLETON;
    }

    @Specialization(replaces = "nanBigDecimals")
    MineBigDecimal getBigDecimals(MineBigDecimal a, MineBigDecimal b) {
        return new MineBigDecimal(a.getValue().remainder(b.getValue()));
    }

    /**
     * 如果求余出错，就返回Nan
     */
    @Fallback
    @SuppressWarnings("unused")
    Object get(Object a, Object b){
        return MineNan.SINGLETON;
    }

    @CompilerDirectives.TruffleBoundary(allowInlining = true)
    boolean notZeroF(float v){
        return v != 0f;
    }

    @CompilerDirectives.TruffleBoundary(allowInlining = true)
    boolean notZeroD(double v){
        return v != 0d;
    }

    @CompilerDirectives.TruffleBoundary(allowInlining = true)
    boolean notZeroBI(MineBigInteger v){
        return !v.getValue().equals(BigInteger.ZERO);
    }

    @CompilerDirectives.TruffleBoundary(allowInlining = true)
    boolean notZeroBD(MineBigDecimal v){
        return v.getValue().compareTo(BigDecimal.ZERO) != 0;
    }
}
