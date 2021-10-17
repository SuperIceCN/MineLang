package me.minelang.tests.operators;

import com.oracle.truffle.api.Truffle;
import me.minelang.compiler.lang.nodes.MineRootNode;
import me.minelang.compiler.lang.nodes.literial.AbstractLiteralNode;
import me.minelang.compiler.lang.nodes.literial.LiteralNodeFactory;
import me.minelang.compiler.lang.nodes.operator.AddOperatorNodeFactory;
import org.junit.Assert;
import org.junit.Test;

public class AddOperatorNodeTest {
    private Object add(AbstractLiteralNode a, AbstractLiteralNode b) {
        var addNode = AddOperatorNodeFactory.create(a, b);
        var rootNode = new MineRootNode(addNode);
        var callTarget = Truffle.getRuntime().createCallTarget(rootNode);
        return callTarget.call();
    }

    @Test
    public void testAdd1() {
        var result = add(
                LiteralNodeFactory.getInstance().createNumberNode("2399999999999999999999999999999"),
                LiteralNodeFactory.getInstance().createNumberNode("2499999999999999999999999999999999999999999999999.333333333333333333333333333333")
        );
        System.out.println(result);
        Assert.assertEquals("2500000000000000002399999999999999999999999999998.333333333333333333333333333333", result.toString());
    }

    @Test
    public void testAdd2() {
        var result = add(
                LiteralNodeFactory.getInstance().createNumberNode("243555"),
                LiteralNodeFactory.getInstance().createNumberNode("43")
        );
        System.out.println(result);
        Assert.assertEquals(243598, result);
    }

    @Test
    public void testAdd3() {
        var result = add(
                LiteralNodeFactory.getInstance().createNumberNode("243.44"),
                LiteralNodeFactory.getInstance().createNumberNode("4300000")
        );
        System.out.println(result);
        Assert.assertEquals(4300243.440002441d, result);
    }

    @Test
    public void testAdd4() {
        var result = add(
                LiteralNodeFactory.getInstance().createNumberNode("127"),
                LiteralNodeFactory.getInstance().createNumberNode("1")
        );
        System.out.println(result);
        Assert.assertEquals((short) 128, result);
    }
}
