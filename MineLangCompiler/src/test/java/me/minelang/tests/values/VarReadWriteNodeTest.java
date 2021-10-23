package me.minelang.tests.values;

import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.frame.FrameDescriptor;
import me.minelang.compiler.lang.nodes.MineNode;
import me.minelang.compiler.lang.nodes.MineRootNode;
import me.minelang.compiler.lang.nodes.literial.LiteralNodeFactory;
import me.minelang.compiler.lang.nodes.operator.AddOperatorNodeFactory;
import me.minelang.compiler.lang.nodes.operator.DivideOperatorNodeFactory;
import me.minelang.compiler.lang.nodes.operator.MultiplyOperatorNodeFactory;
import me.minelang.compiler.lang.nodes.value.LocalVarReadNodeFactory;
import me.minelang.compiler.lang.nodes.value.LocalVarWriteNodeFactory;
import me.minelang.compiler.lang.types.MineNone;
import org.junit.Assert;
import org.junit.Test;

public class VarReadWriteNodeTest {
    @Test
    public void testVar() {
        var frameDescriptor = new FrameDescriptor(MineNone.SINGLETON);
        var valueNode = LiteralNodeFactory.getInstance().createNumberNode("2222");
        var writeNode = LocalVarWriteNodeFactory.create(valueNode, "x");
        var readNode = LocalVarReadNodeFactory.create("x");
        var calcNode = AddOperatorNodeFactory.create(readNode, LiteralNodeFactory.getInstance().createNumberNode("11"));
        var rootNode = new MineRootNode(null, new MineNode[]{writeNode, calcNode}, frameDescriptor);
        var callTarget = Truffle.getRuntime().createCallTarget(rootNode);
        var result = callTarget.call();
        Assert.assertEquals(2233, result);
    }

    @Test
    public void testReadUndefined() {
        var frameDescriptor = new FrameDescriptor(MineNone.SINGLETON);
        var readNode = LocalVarReadNodeFactory.create("x");
        var rootNode = new MineRootNode(null, new MineNode[]{readNode}, frameDescriptor);
        var callTarget = Truffle.getRuntime().createCallTarget(rootNode);
        var result = callTarget.call();
        Assert.assertEquals(MineNone.SINGLETON, result);
    }

    @Test
    public void testCalc() {
        var frameDescriptor = new FrameDescriptor(MineNone.SINGLETON);
        var writeNode1 = LocalVarWriteNodeFactory.create(LiteralNodeFactory.getInstance().createNumberNode("2"), "x");
        var calcNode1 = MultiplyOperatorNodeFactory.create(
                LocalVarReadNodeFactory.create("x"), LiteralNodeFactory.getInstance().createNumberNode("2")
        );
        var writeNode2 = LocalVarWriteNodeFactory.create(calcNode1, "x");
        var calcNode2 = DivideOperatorNodeFactory.create(
                LocalVarReadNodeFactory.create("x"), LiteralNodeFactory.getInstance().createNumberNode("3.0")
        );
        var rootNode = new MineRootNode(null, new MineNode[]{writeNode1, writeNode2, calcNode2}, frameDescriptor);
        var callTarget = Truffle.getRuntime().createCallTarget(rootNode);
        var result = callTarget.call();
        Assert.assertEquals(1.3333334f, result);
    }
}
