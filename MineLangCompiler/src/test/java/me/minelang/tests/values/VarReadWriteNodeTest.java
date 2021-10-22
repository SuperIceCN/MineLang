package me.minelang.tests.values;

import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.FrameSlotKind;
import me.minelang.compiler.lang.nodes.MineNode;
import me.minelang.compiler.lang.nodes.MineRootNode;
import me.minelang.compiler.lang.nodes.literial.LiteralNodeFactory;
import me.minelang.compiler.lang.nodes.operator.AddOperatorNodeFactory;
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
        var slot = frameDescriptor.addFrameSlot("x", FrameSlotKind.Int);
        var writeNode = LocalVarWriteNodeFactory.create(valueNode, slot);
        var readNode = LocalVarReadNodeFactory.create(slot);
        var calcNode = AddOperatorNodeFactory.create(readNode, LiteralNodeFactory.getInstance().createNumberNode("11"));
        var rootNode = new MineRootNode(null, new MineNode[]{writeNode, calcNode}, frameDescriptor);
        var callTarget = Truffle.getRuntime().createCallTarget(rootNode);
        var result = callTarget.call();
        Assert.assertEquals(2233, result);
    }

    @Test
    public void testReadUndefined() {
        var frameDescriptor = new FrameDescriptor(MineNone.SINGLETON);
        var slot = frameDescriptor.addFrameSlot("x", FrameSlotKind.Int);
        var readNode = LocalVarReadNodeFactory.create(slot);
        var rootNode = new MineRootNode(null, new MineNode[]{readNode}, frameDescriptor);
        var callTarget = Truffle.getRuntime().createCallTarget(rootNode);
        var result = callTarget.call();
        Assert.assertEquals(MineNone.SINGLETON, result);
    }
}
