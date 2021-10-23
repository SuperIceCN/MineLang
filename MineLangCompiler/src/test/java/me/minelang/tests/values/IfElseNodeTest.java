package me.minelang.tests.values;

import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.FrameSlotKind;
import me.minelang.compiler.lang.nodes.MineRootNode;
import me.minelang.compiler.lang.nodes.control.BlockNodeFactory;
import me.minelang.compiler.lang.nodes.control.IfElseNodeFactory;
import me.minelang.compiler.lang.nodes.literial.LiteralNodeFactory;
import me.minelang.compiler.lang.nodes.value.LocalVarReadNodeFactory;
import me.minelang.compiler.lang.nodes.value.LocalVarWriteNodeFactory;
import me.minelang.compiler.lang.types.MineNone;
import org.junit.Assert;
import org.junit.Test;

public class IfElseNodeTest {
    @Test
    public void testIfElse1() {
        var trueNode = LiteralNodeFactory.getInstance().createBoolNode(true);
        var ifElseNode = IfElseNodeFactory.create(trueNode, BlockNodeFactory.create(
                LiteralNodeFactory.getInstance().createNumberNode("2233")
        ));
        var rootNode = new MineRootNode(ifElseNode);
        var callTarget = Truffle.getRuntime().createCallTarget(rootNode);
        var result = callTarget.call();
        Assert.assertEquals((short) 2233, result);
    }

    @Test
    public void testIfElse2() {
        var frameDescriptor = new FrameDescriptor(MineNone.SINGLETON);
        var slot = frameDescriptor.addFrameSlot("x", FrameSlotKind.Boolean);
        var writeNode1 = LocalVarWriteNodeFactory.create(LiteralNodeFactory.getInstance().createBoolNode(false)
                , slot);
        var ifElseNode = IfElseNodeFactory.create(LocalVarReadNodeFactory.create(frameDescriptor.findOrAddFrameSlot("x", FrameSlotKind.Boolean))
                , BlockNodeFactory.create(LiteralNodeFactory.getInstance().createNumberNode("2233"))
                        , BlockNodeFactory.create(LocalVarReadNodeFactory.create(frameDescriptor.findOrAddFrameSlot("x", FrameSlotKind.Boolean))));
        var rootNode = new MineRootNode(frameDescriptor, writeNode1, ifElseNode);
        var callTarget = Truffle.getRuntime().createCallTarget(rootNode);
        var result = callTarget.call();
        Assert.assertEquals(false, result);
    }
}
