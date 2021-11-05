package me.minelang.compiler.lang.nodes.function;

import com.oracle.truffle.api.dsl.Fallback;
import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;
import me.minelang.compiler.lang.exceptions.control.FunctionReturnException;
import me.minelang.compiler.lang.nodes.MineNode;
import me.minelang.compiler.lang.types.*;

@NodeInfo(language = "MineLang", shortName = "return", description = "Return a value to end the exec of a function.")
@NodeChild(value = "value", type = MineNode.class)
public abstract class ReturnNode extends MineNode {
    @Specialization
    byte getByte(byte a){
        throw FunctionReturnException.create(a);
    }

    @Specialization
    short getShort(short a){
        throw FunctionReturnException.create(a);
    }

    @Specialization
    int getInt(int a){
        throw FunctionReturnException.create(a);
    }

    @Specialization
    long getLong(long a){
        throw FunctionReturnException.create(a);
    }

    @Specialization
    MineBigInteger getBigInteger(MineBigInteger a){
        throw FunctionReturnException.create(a);
    }

    @Specialization
    float getFloat(float a){
        throw FunctionReturnException.create(a);
    }

    @Specialization
    double getDouble(double a){
        throw FunctionReturnException.create(a);
    }

    @Specialization
    MineBigDecimal getBigDecimal(MineBigDecimal a){
        throw FunctionReturnException.create(a);
    }

    @Specialization
    MineNan getMineNan(MineNan a) {
        throw FunctionReturnException.create(a);
    }

    @Specialization
    MineNone getMineNone(MineNone a) {
        throw FunctionReturnException.create();
    }

    @Specialization
    MineFunction getMineFunction(MineFunction a) {
        throw FunctionReturnException.create(a);
    }

    @Specialization
    String getString(String a) {
        throw FunctionReturnException.create(a);
    }

    @Fallback
    @SuppressWarnings("unused")
    Object get(Object a){
        throw FunctionReturnException.create(a);
    }
}
