package me.minelang.compiler.lang.nodes.operator;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;
import me.minelang.compiler.lang.nodes.MineNode;
import me.minelang.compiler.lang.types.MineBigDecimal;
import me.minelang.compiler.lang.types.MineBigInteger;

@NodeInfo(language = "MineLang", shortName = ">=", description = "operatorGreaterEqual")
@NodeChild(value = "left", type = MineNode.class)
@NodeChild(value = "right", type = MineNode.class)
public abstract class GreaterEqualOperatorNode extends AbstractOperatorNode {
    @Specialization
    boolean compareBytes(byte a, byte b) {
        return a >= b;
    }

    @Specialization
    boolean compareShorts(short a, short b) {
        return a >= b;
    }

    @Specialization
    boolean compareInts(int a, int b) {
        return a >= b;
    }

    @Specialization
    boolean compareLongs(long a, long b) {
        return a >= b;
    }

    @Specialization
    boolean compareBigIntegers(MineBigInteger a, MineBigInteger b) {
        return a.compareTo(b) >= 0;
    }

    @Specialization
    boolean compareFloats(float a, float b) {
        return a >= b;
    }

    @Specialization
    boolean compareDoubles(double a, double b) {
        return a >= b;
    }

    @Specialization
    boolean compareBigDecimals(MineBigDecimal a, MineBigDecimal b) {
        return a.compareTo(b) >= 0;
    }

    @Specialization
    boolean compareStrings(String a, String b) {
        return a.compareTo(b) >= 0;
    }

    @Specialization(guards = "isComparable(a, b)")
    @SuppressWarnings({"unchecked", "rawtypes"})
    boolean compareComparable(Object a, Object b) {
        return ((Comparable) a).compareTo(b) >= 0;
    }

    boolean isComparable(Object a, Object b) {
        return a instanceof Comparable && b instanceof Comparable && (a.getClass().isInstance(b) || b.getClass().isInstance(a));
    }
}
