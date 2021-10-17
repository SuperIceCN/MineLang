package me.minelang.tests.operators;

import com.oracle.truffle.api.Truffle;
import me.minelang.compiler.lang.nodes.MineRootNode;
import me.minelang.compiler.lang.nodes.literial.AbstractLiteralNode;
import me.minelang.compiler.lang.nodes.literial.LiteralNodeFactory;
import me.minelang.compiler.lang.nodes.operator.NegativeOperatorNodeFactory;
import me.minelang.compiler.lang.nodes.operator.PositiveOperatorNodeFactory;
import me.minelang.compiler.lang.types.MineBigDecimal;
import me.minelang.compiler.lang.types.MineBigInteger;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

public class PosNegOperatorTest {
    private Object pos(AbstractLiteralNode a) {
        var addNode = PositiveOperatorNodeFactory.create(a);
        var rootNode = new MineRootNode(addNode);
        var callTarget = Truffle.getRuntime().createCallTarget(rootNode);
        return callTarget.call();
    }

    private Object neg(AbstractLiteralNode a) {
        var negNode = NegativeOperatorNodeFactory.create(a);
        var rootNode = new MineRootNode(negNode);
        var callTarget = Truffle.getRuntime().createCallTarget(rootNode);
        return callTarget.call();
    }

    @Test
    public void testPositive() {
        Assert.assertEquals((byte) 127, pos(LiteralNodeFactory.getInstance().createNumberNode("127")));
        Assert.assertEquals((short) 128, pos(LiteralNodeFactory.getInstance().createNumberNode("128")));
        Assert.assertEquals(65536, pos(LiteralNodeFactory.getInstance().createNumberNode("65536")));
        Assert.assertEquals(8888777766665555L, pos(LiteralNodeFactory.getInstance().createNumberNode("8888777766665555")));
        Assert.assertEquals(new MineBigInteger(new BigInteger("999988887777666655554444333322221111")), pos(LiteralNodeFactory.getInstance().createNumberNode("999988887777666655554444333322221111")));
        Assert.assertEquals(2.3f, pos(LiteralNodeFactory.getInstance().createNumberNode("2.3")));
        Assert.assertEquals(2233.2233d, pos(LiteralNodeFactory.getInstance().createNumberNode("2233.2233")));
        Assert.assertEquals(new MineBigDecimal(new BigDecimal("9876543210.123456789")), pos(LiteralNodeFactory.getInstance().createNumberNode("9876543210.123456789")));
    }

    @Test
    public void testNegative() {
        Assert.assertEquals((byte) -127, neg(LiteralNodeFactory.getInstance().createNumberNode("127")));
        Assert.assertEquals((short) 128, neg(LiteralNodeFactory.getInstance().createNumberNode("-128")));
        Assert.assertEquals((short) -32767, neg(LiteralNodeFactory.getInstance().createNumberNode("32767")));
        Assert.assertEquals(32768, neg(LiteralNodeFactory.getInstance().createNumberNode("-32768")));
        Assert.assertEquals(-8888777766665555L, neg(LiteralNodeFactory.getInstance().createNumberNode("8888777766665555")));
        Assert.assertEquals(new MineBigInteger(new BigInteger("999988887777666655554444333322221111").negate()), neg(LiteralNodeFactory.getInstance().createNumberNode("999988887777666655554444333322221111")));
        Assert.assertEquals(-2.3f, neg(LiteralNodeFactory.getInstance().createNumberNode("2.3")));
        Assert.assertEquals(-2233.2233d, neg(LiteralNodeFactory.getInstance().createNumberNode("2233.2233")));
        Assert.assertEquals(new MineBigDecimal(new BigDecimal("9876543210.123456789").negate()), neg(LiteralNodeFactory.getInstance().createNumberNode("9876543210.123456789")));
    }
}
