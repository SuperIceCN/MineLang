package me.minelang.compiler.lang.nodes.operator;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;
import me.minelang.compiler.lang.nodes.MineNode;
import me.minelang.compiler.lang.types.MineBigDecimal;
import me.minelang.compiler.lang.types.MineBigInteger;

@NodeInfo(language = "MineLang", shortName = "+", description = "operatorPositive")
@NodeChild(value = "node", type = MineNode.class)
public abstract class PositiveOperatorNode extends AbstractOperatorNode {
    @Specialization
    byte getByte(byte a){
        return a;
    }

    @Specialization
    short getShort(short a){
        return a;
    }

    @Specialization
    int getInt(int a){
        return a;
    }

    @Specialization
    long getLong(long a){
        return a;
    }

    @Specialization
    MineBigInteger getBigInteger(MineBigInteger a){
        return a;
    }

    @Specialization
    float getFloat(float a){
        return a;
    }

    @Specialization
    double getDouble(double a){
        return a;
    }

    @Specialization
    MineBigDecimal getBigDecimal(MineBigDecimal a){
        return a;
    }
}
