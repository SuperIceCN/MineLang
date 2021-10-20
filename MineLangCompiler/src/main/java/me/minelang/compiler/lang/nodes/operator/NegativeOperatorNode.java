package me.minelang.compiler.lang.nodes.operator;

import com.oracle.truffle.api.dsl.Fallback;
import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;
import me.minelang.compiler.lang.nodes.MineNode;
import me.minelang.compiler.lang.types.MineBigDecimal;
import me.minelang.compiler.lang.types.MineBigInteger;
import me.minelang.compiler.lang.types.MineNan;

@NodeInfo(language = "MineLang", shortName = "-", description = "operatorNegative")
@NodeChild(value = "node", type = MineNode.class)
public abstract class NegativeOperatorNode extends AbstractOperatorNode {
    @Specialization(rewriteOn = ArithmeticException.class)
    byte getByte(byte a){
        if(a != Byte.MIN_VALUE){
            return (byte) -a;
        }else {
            throw new ArithmeticException("byte overflow");
        }
    }

    @Specialization(rewriteOn = ArithmeticException.class)
    short getShort(short a){
        if(a != Short.MIN_VALUE){
            return (short) -a;
        }else {
            throw new ArithmeticException("short overflow");
        }
    }

    @Specialization(rewriteOn = ArithmeticException.class)
    int getInt(int a){
        if(a != Integer.MIN_VALUE){
            return -a;
        }else {
            throw new ArithmeticException("int overflow");
        }
    }

    @Specialization(rewriteOn = ArithmeticException.class)
    long getLong(long a){
        if(a != Long.MIN_VALUE){
            return -a;
        }else {
            throw new ArithmeticException("long overflow");
        }
    }

    @Specialization
    MineBigInteger getBigInteger(MineBigInteger a){
        return new MineBigInteger(a.getValue().negate());
    }

    @Specialization
    float getFloat(float a){
        return -a;
    }

    @Specialization
    double getDouble(double a){
        return -a;
    }

    @Specialization
    MineBigDecimal getBigDecimal(MineBigDecimal a){
        return new MineBigDecimal(a.getValue().negate());
    }

    @Fallback
    @SuppressWarnings("unused")
    Object get(Object a){
        return MineNan.SINGLETON;
    }
}
