package me.minelang.compiler.lang.nodes.operator;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;
import me.minelang.compiler.lang.nodes.MineNode;
import me.minelang.compiler.lang.types.MineBigDecimal;
import me.minelang.compiler.lang.types.MineBigInteger;

@NodeInfo(language = "MineLang", shortName = "+", description = "operatorAdd")
@NodeChild(value = "left", type = MineNode.class)
@NodeChild(value = "right", type = MineNode.class)
public abstract class AddOperatorNode extends AbstractOperatorNode {

    @Specialization(rewriteOn = ArithmeticException.class)
    byte addBytes(byte a, byte b) {
        var x = a + b;
        var r = (byte) x;
        if (x == r) {
            return r;
        } else {
            throw new ArithmeticException("byte overflow");
        }
    }

    @Specialization(rewriteOn = ArithmeticException.class)
    short addShorts(short a, short b) {
        var x = a + b;
        var r = (short) x;
        if (x == r) {
            return r;
        } else {
            throw new ArithmeticException("short overflow");
        }
    }

    @Specialization(rewriteOn = ArithmeticException.class)
    int addInts(int a, int b) {
        return Math.addExact(a, b);
    }

    @Specialization(rewriteOn = ArithmeticException.class)
    long addLongs(long a, long b) {
        return Math.addExact(a, b);
    }

    @Specialization
    MineBigInteger addBigIntegers(MineBigInteger a, MineBigInteger b) {
        return new MineBigInteger(a.getValue().add(b.getValue()));
    }

    @Specialization(rewriteOn = ArithmeticException.class)
    float addFloats(float a, float b) {
        var x = a + b;
        if (x >= Float.MAX_VALUE || x <= Float.MIN_VALUE) {
            return x;
        } else {
            throw new ArithmeticException("float overflow");
        }
    }

    @Specialization(rewriteOn = ArithmeticException.class)
    double addDoubles(double a, double b) {
        var x = a + b;
        if (x >= Double.MIN_VALUE || x <= Double.MAX_VALUE) {
            return x;
        } else {
            throw new ArithmeticException("double overflow");
        }
    }

    @Specialization
    MineBigDecimal addBigDecimals(MineBigDecimal a, MineBigDecimal b) {
        return new MineBigDecimal(a.getValue().add(b.getValue()));
    }

    @Specialization
    String addStrings(String a, String b) {
        return a + b;
    }
}
