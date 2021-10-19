package me.minelang.compiler.lang.nodes.operator;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;
import me.minelang.compiler.lang.nodes.MineNode;
import me.minelang.compiler.lang.types.MineBigDecimal;
import me.minelang.compiler.lang.types.MineBigInteger;

@NodeInfo(language = "MineLang", shortName = "-", description = "operatorMinus")
@NodeChild(value = "left", type = MineNode.class)
@NodeChild(value = "right", type = MineNode.class)
public abstract class MinusOperatorNode extends AbstractOperatorNode {

    @Specialization(rewriteOn = ArithmeticException.class)
    byte getBytes(byte a, byte b) {
        var x = a - b;
        var r = (byte) x;
        if (x == r) {
            return r;
        } else {
            throw new ArithmeticException("byte overflow");
        }
    }

    @Specialization(rewriteOn = ArithmeticException.class)
    short getShorts(short a, short b) {
        var x = a - b;
        var r = (short) x;
        if (x == r) {
            return r;
        } else {
            throw new ArithmeticException("short overflow");
        }
    }

    @Specialization(rewriteOn = ArithmeticException.class)
    int getInts(int a, int b) {
        if(b != Integer.MIN_VALUE){
            return Math.addExact(a, -b);
        }else {
            throw new ArithmeticException("int overflow");
        }
    }

    @Specialization(rewriteOn = ArithmeticException.class)
    long getLongs(long a, long b) {
        if(b != Long.MIN_VALUE){
            return Math.addExact(a, -b);
        }else {
            throw new ArithmeticException("long overflow");
        }
    }

    @Specialization
    MineBigInteger getBigIntegers(MineBigInteger a, MineBigInteger b) {
        return new MineBigInteger(a.getValue().add(b.getValue().negate()));
    }

    @Specialization(rewriteOn = ArithmeticException.class)
    float getFloats(float a, float b) {
        var x = a - b;
        if (x >= -Float.MAX_VALUE || x <= Float.MAX_VALUE) {
            return x;
        } else {
            throw new ArithmeticException("float overflow");
        }
    }

    @Specialization(rewriteOn = ArithmeticException.class)
    double getDoubles(double a, double b) {
        var x = a - b;
        if (x >= -Double.MAX_VALUE || x <= Double.MAX_VALUE) {
            return x;
        } else {
            throw new ArithmeticException("double overflow");
        }
    }

    @Specialization
    MineBigDecimal getBigDecimals(MineBigDecimal a, MineBigDecimal b) {
        return new MineBigDecimal(a.getValue().add(b.getValue().negate()));
    }
}
