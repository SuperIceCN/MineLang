package me.minelang.compiler.lang.nodes.control;

import com.oracle.truffle.api.dsl.Fallback;
import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;
import me.minelang.compiler.lang.exceptions.LoopBreakException;
import me.minelang.compiler.lang.nodes.MineNode;
import me.minelang.compiler.lang.types.*;

@NodeInfo(language = "MineLang", shortName = "break", description = "Break current loop.")
@NodeChild(value = "node", type = MineNode.class)
public abstract class BreakNode extends MineNode {
    @Specialization
    byte getByte(byte a){
        throw LoopBreakException.create(a);
    }

    @Specialization
    short getShort(short a){
        throw LoopBreakException.create(a);
    }

    @Specialization
    int getInt(int a){
        throw LoopBreakException.create(a);
    }

    @Specialization
    long getLong(long a){
        throw LoopBreakException.create(a);
    }

    @Specialization
    MineBigInteger getBigInteger(MineBigInteger a){
        throw LoopBreakException.create(a);
    }

    @Specialization
    float getFloat(float a){
        throw LoopBreakException.create(a);
    }

    @Specialization
    double getDouble(double a){
        throw LoopBreakException.create(a);
    }

    @Specialization
    MineBigDecimal getBigDecimal(MineBigDecimal a){
        throw LoopBreakException.create(a);
    }

    @Specialization
    MineNan getMineNan(MineNan a) {
        throw LoopBreakException.create(a);
    }

    @Specialization
    MineNone getMineNone(MineNone a) {
        throw LoopBreakException.create();
    }

    @Specialization
    MineFunction getMineFunction(MineFunction a) {
        throw LoopBreakException.create(a);
    }

    @Specialization
    String getString(String a) {
        throw LoopBreakException.create(a);
    }

    @Fallback
    @SuppressWarnings("unused")
    Object get(Object a){
        throw LoopBreakException.create(a);
    }
}
