package me.minelang.compiler.lang.nodes.operator;

import com.oracle.truffle.api.dsl.Fallback;
import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;
import me.minelang.compiler.lang.nodes.MineNode;
import me.minelang.compiler.lang.types.MineBigDecimal;
import me.minelang.compiler.lang.types.MineBigInteger;
import me.minelang.compiler.lang.types.MineNan;
import me.minelang.compiler.lang.types.MineUndefined;

@NodeInfo(language = "MineLang", shortName = "==", description = "operatorEqual")
@NodeChild(value = "left", type = MineNode.class)
@NodeChild(value = "right", type = MineNode.class)
public abstract class EqualOperatorNode extends AbstractOperatorNode {
    @Specialization
    boolean compareBools(boolean a, boolean b) {
        return a == b;
    }

    @Specialization
    boolean compareBytes(byte a, byte b) {
        return a == b;
    }

    @Specialization
    boolean compareShorts(short a, short b) {
        return a == b;
    }

    @Specialization
    boolean compareInts(int a, int b) {
        return a == b;
    }

    @Specialization
    boolean compareLongs(long a, long b) {
        return a == b;
    }

    @Specialization
    boolean compareBigIntegers(MineBigInteger a, MineBigInteger b) {
        return a.compareTo(b) == 0;
    }

    @Specialization
    boolean compareFloats(float a, float b) {
        return a == b;
    }

    @Specialization
    boolean compareDoubles(double a, double b) {
        return a == b;
    }

    @Specialization
    boolean compareBigDecimals(MineBigDecimal a, MineBigDecimal b) {
        return a.compareTo(b) == 0;
    }

    @Specialization
    boolean compareStrings(String a, String b) {
        return a.equals(b);
    }

    @Specialization
    boolean compareMineNones(MineNode a, MineNode b) {
        return a == b;
    }

    /*
     * Nan永远不相等
     */
    @Specialization
    boolean compareMineNan(MineNan a, MineNan b) {
        return false;
    }

    @Specialization
    boolean compareUndefined(MineUndefined a, MineUndefined b) {
        return a == b;
    }

    @Fallback
    @SuppressWarnings("unused")
    Object compare(Object a, Object b) {
        return a.equals(b);
    }
}
