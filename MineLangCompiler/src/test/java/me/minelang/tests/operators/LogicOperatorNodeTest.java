package me.minelang.tests.operators;

import com.oracle.truffle.api.Truffle;
import me.minelang.compiler.lang.nodes.MineNode;
import me.minelang.compiler.lang.nodes.MineRootNode;
import me.minelang.compiler.lang.nodes.literial.LiteralNodeFactory;
import me.minelang.compiler.lang.nodes.operator.*;
import org.junit.Assert;
import org.junit.Test;

public class LogicOperatorNodeTest {
    public boolean logic(boolean isAnd, boolean a, boolean b) {
        var aNode = LiteralNodeFactory.getInstance().createBoolNode(a);
        var bNode = LiteralNodeFactory.getInstance().createBoolNode(b);
        var addNode = isAnd ? LogicalAndOperatorNodeFactory.create(aNode, bNode) : LogicalOrOperatorNodeFactory.create(aNode, bNode);
        var rootNode = new MineRootNode(addNode);
        var callTarget = Truffle.getRuntime().createCallTarget(rootNode);
        return (boolean) callTarget.call();
    }

    public boolean logic(boolean a) {
        var aNode = LiteralNodeFactory.getInstance().createBoolNode(a);
        var addNode = LogicalNotOperatorNodeFactory.create(aNode);
        var rootNode = new MineRootNode(addNode);
        var callTarget = Truffle.getRuntime().createCallTarget(rootNode);
        return (boolean) callTarget.call();
    }

    public boolean equal(boolean reverse, MineNode aNode, MineNode bNode) {
        var addNode = !reverse ? EqualOperatorNodeFactory.create(aNode, bNode) : NotEqualOperatorNodeFactory.create(aNode, bNode);
        var rootNode = new MineRootNode(addNode);
        var callTarget = Truffle.getRuntime().createCallTarget(rootNode);
        return (boolean) callTarget.call();
    }

    @Test
    public void testAnd() {
        Assert.assertTrue(logic(true, true, true));
        Assert.assertFalse(logic(true, false, true));
        Assert.assertFalse(logic(true, true, false));
        Assert.assertFalse(logic(true, false, false));
    }

    @Test
    public void testOr() {
        Assert.assertTrue(logic(false, true, true));
        Assert.assertTrue(logic(false, false, true));
        Assert.assertTrue(logic(false, true, false));
        Assert.assertFalse(logic(false, false, false));
    }

    @Test
    public void testNot() {
        Assert.assertTrue(logic(false));
        Assert.assertFalse(logic(true));
    }

    @Test
    public void testEqual() {
        Assert.assertFalse(equal(false, LiteralNodeFactory.getInstance().createBoolNode(true), LiteralNodeFactory.getInstance().createBoolNode(false)));
        Assert.assertTrue(equal(false, LiteralNodeFactory.getInstance().createBoolNode(true), LiteralNodeFactory.getInstance().createBoolNode(true)));
        Assert.assertTrue(equal(false, LiteralNodeFactory.getInstance().createBoolNode(false), LiteralNodeFactory.getInstance().createBoolNode(false)));
        Assert.assertTrue(equal(false, LiteralNodeFactory.getInstance().createStringNode("hello"), LiteralNodeFactory.getInstance().createStringNode("hell!".replace("!", "o"))));
        Assert.assertTrue(equal(false, LiteralNodeFactory.getInstance().createNumberNode("23"), LiteralNodeFactory.getInstance().createNumberNode("23")));
        Assert.assertTrue(equal(false, LiteralNodeFactory.getInstance().createNumberNode("2233"), LiteralNodeFactory.getInstance().createNumberNode("2233")));
        Assert.assertTrue(equal(false, LiteralNodeFactory.getInstance().createNumberNode("5202233"), LiteralNodeFactory.getInstance().createNumberNode("5202233")));
        Assert.assertTrue(equal(false, LiteralNodeFactory.getInstance().createNumberNode("22.33"), LiteralNodeFactory.getInstance().createNumberNode("22.33")));
        // 精度不同不应相等
        Assert.assertFalse(equal(false, LiteralNodeFactory.getInstance().createNumberNode("2.233"), LiteralNodeFactory.getInstance().createNumberNode("2.233000000000000000000000")));
        Assert.assertFalse(equal(false, LiteralNodeFactory.getInstance().createNumberNode("2.233"), LiteralNodeFactory.getInstance().createNumberNode("2.233000000")));
        Assert.assertTrue(equal(false, LiteralNodeFactory.getInstance().createNumberNode("2233"), LiteralNodeFactory.getInstance().createNumberNode("2233.00")));
        Assert.assertFalse(equal(false, LiteralNodeFactory.getInstance().createNumberNode("52052052052052052022332233"), LiteralNodeFactory.getInstance().createNumberNode("5205205202233")));
    }
}
