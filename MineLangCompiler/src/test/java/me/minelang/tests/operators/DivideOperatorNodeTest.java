package me.minelang.tests.operators;

import com.oracle.truffle.api.Truffle;
import me.minelang.compiler.lang.nodes.MineRootNode;
import me.minelang.compiler.lang.nodes.literial.LiteralNodeFactory;
import me.minelang.compiler.lang.nodes.operator.DivideOperatorNodeFactory;
import me.minelang.compiler.lang.types.MineNan;
import org.junit.Assert;
import org.junit.Test;

public class DivideOperatorNodeTest {
    private Object div(String a, String b) {
        var aNode = LiteralNodeFactory.getInstance().createNumberNode(a);
        var bNode = LiteralNodeFactory.getInstance().createNumberNode(b);
        var addNode = DivideOperatorNodeFactory.create(aNode, bNode);
        var rootNode = new MineRootNode(addNode);
        var callTarget = Truffle.getRuntime().createCallTarget(rootNode);
        return callTarget.call();
    }

    @Test
    public void testDivide1() {
        Assert.assertEquals(MineNan.SINGLETON, div("2", "0"));
    }

    @Test
    public void testDivide2() {
        Assert.assertEquals((byte) 23, div("69", "3"));
    }

    @Test
    public void testDivide3() {
        Assert.assertEquals(-10.0f, (float) div("98.82", "-9.882"), 0.00001f);
    }

    @Test
    public void testDivide4() {
        Assert.assertEquals(MineNan.SINGLETON, div("12.34", "0"));
    }
}
