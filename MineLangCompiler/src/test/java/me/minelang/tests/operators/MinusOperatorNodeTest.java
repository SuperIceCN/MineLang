package me.minelang.tests.operators;

import com.oracle.truffle.api.Truffle;
import me.minelang.compiler.lang.nodes.MineRootNode;
import me.minelang.compiler.lang.nodes.literial.AbstractLiteralNode;
import me.minelang.compiler.lang.nodes.literial.LiteralNodeFactory;
import me.minelang.compiler.lang.nodes.operator.MinusOperatorNodeFactory;
import org.junit.Assert;
import org.junit.Test;

public class MinusOperatorNodeTest {
    private Object min(AbstractLiteralNode a, AbstractLiteralNode b) {
        var addNode = MinusOperatorNodeFactory.create(a, b);
        var rootNode = new MineRootNode(addNode);
        var callTarget = Truffle.getRuntime().createCallTarget(rootNode);
        return callTarget.call();
    }

    @Test
    public void testAdd1() {
        var result = min(
                LiteralNodeFactory.getInstance().createNumberNode("2399999999999999999999999999999"),
                LiteralNodeFactory.getInstance().createNumberNode("2499999999999999999999999999999999999999999999999.333333333333333333333333333333")
        );
        System.out.println(result);
        Assert.assertEquals("-2499999999999999997600000000000000000000000000000.333333333333333333333333333333", result.toString());
    }

    @Test
    public void testAdd2() {
        var result = min(
                LiteralNodeFactory.getInstance().createNumberNode("243555"),
                LiteralNodeFactory.getInstance().createNumberNode("43")
        );
        System.out.println(result);
        Assert.assertEquals(243512, result);
    }

    @Test
    public void testAdd3() {
        var result = min(
                LiteralNodeFactory.getInstance().createNumberNode("243.44"),
                LiteralNodeFactory.getInstance().createNumberNode("4300000")
        );
        System.out.println(result);
        Assert.assertEquals(-4299756.5f, result);
    }

    @Test
    public void testAdd4() {
        var result = min(
                LiteralNodeFactory.getInstance().createNumberNode("127"),
                LiteralNodeFactory.getInstance().createNumberNode("-1")
        );
        System.out.println(result);
        Assert.assertEquals((short) 128, result);
    }
}
