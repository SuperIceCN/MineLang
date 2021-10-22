package me.minelang.tests.operators;

import com.oracle.truffle.api.Truffle;
import me.minelang.compiler.lang.nodes.MineRootNode;
import me.minelang.compiler.lang.nodes.literial.LiteralNodeFactory;
import me.minelang.compiler.lang.nodes.operator.LogicalAndOperatorNodeFactory;
import me.minelang.compiler.lang.nodes.operator.LogicalNotOperatorNodeFactory;
import me.minelang.compiler.lang.nodes.operator.LogicalOrOperatorNodeFactory;
import org.junit.Assert;
import org.junit.Test;

public class LogicOperatorNodeTest {
    public boolean logic(boolean isAnd, boolean a, boolean b) {
        var aNode = LiteralNodeFactory.getInstance().createBoolNode(a);
        var bNode = LiteralNodeFactory.getInstance().createBoolNode(b);
        var addNode = isAnd? LogicalAndOperatorNodeFactory.create(aNode, bNode) : LogicalOrOperatorNodeFactory.create(aNode, bNode);
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
}
