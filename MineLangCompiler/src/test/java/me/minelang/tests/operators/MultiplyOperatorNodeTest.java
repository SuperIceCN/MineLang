package me.minelang.tests.operators;

import com.oracle.truffle.api.Truffle;
import me.minelang.compiler.lang.nodes.MineRootNode;
import me.minelang.compiler.lang.nodes.literial.LiteralNodeFactory;
import me.minelang.compiler.lang.nodes.operator.MultiplyOperatorNodeFactory;
import me.minelang.compiler.lang.types.MineBigDecimal;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class MultiplyOperatorNodeTest {
    private Object mul(String a, String b) {
        var aNode = LiteralNodeFactory.getInstance().createNumberNode(a);
        var bNode = LiteralNodeFactory.getInstance().createNumberNode(b);
        var addNode = MultiplyOperatorNodeFactory.create(aNode, bNode);
        var rootNode = new MineRootNode(addNode);
        var callTarget = Truffle.getRuntime().createCallTarget(rootNode);
        return callTarget.call();
    }

    @Test
    public void testMultiply1() {
        Assert.assertEquals((byte) 80, mul("8", "10"));
    }

    @Test
    public void testMultiply2() {
        Assert.assertEquals((short) 512, mul("64", "8"));
    }

    @Test
    public void testMultiply3() {
        Assert.assertEquals(60f, mul("5.0", "12.0"));
    }

    @Test
    public void testMultiply4() {
        Assert.assertEquals(new MineBigDecimal(new BigDecimal("462831.23333333333333333333333333333326693")), mul("19921", "23.23333333333333333333333333333333333"));
    }
}
