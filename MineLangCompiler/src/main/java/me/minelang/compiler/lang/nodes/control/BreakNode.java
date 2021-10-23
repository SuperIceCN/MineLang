package me.minelang.compiler.lang.nodes.control;

import com.oracle.truffle.api.dsl.Fallback;
import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;
import me.minelang.compiler.lang.nodes.MineNode;
import me.minelang.compiler.lang.types.*;

@NodeInfo(language = "MineLang", shortName = "break", description = "Break current loop.")
@NodeChild(value = "node", type = MineNode.class)
public abstract class BreakNode extends MineNode {
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

    @Specialization
    MineNan getMineNan(MineNan a) {
        return a;
    }

    @Specialization
    MineNone getMineNone(MineNone a) {
        return a;
    }

    @Specialization
    MineFunction getMineFunction(MineFunction a) {
        return a;
    }

    @Specialization
    String getString(String a) {
        return a;
    }

    @Fallback
    @SuppressWarnings("unused")
    Object get(Object a){
        return a;
    }
}
