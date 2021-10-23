package me.minelang.compiler.lang.nodes.control;

import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.LoopNode;
import com.oracle.truffle.api.nodes.NodeInfo;
import me.minelang.compiler.lang.nodes.MineNode;

@NodeInfo(language = "MineLang", shortName = "loop", description = "A simple endless loop.")
public final class EndlessLoopNode extends MineNode {
    @Child LoopNode loopNode;
    @Child MineNode elseBlock;

    private final MineNode bodyNode;

    EndlessLoopNode(MineNode conditionNode, MineNode bodyNode, MineNode elseBlock) {
        this.bodyNode = bodyNode;
        this.loopNode = Truffle.getRuntime().createLoopNode(new RepeatNode(conditionNode, bodyNode));
        this.elseBlock = elseBlock;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        if(bodyNode instanceof BlockNode blockNode) {
            var descriptor = blockNode.descriptor;
            var blockFrame = Truffle.getRuntime().createVirtualFrame(new Object[]{frame.materialize()}, descriptor);
            loopNode.execute(blockFrame);
        }else {
            loopNode.execute(frame);
        }
        if(elseBlock instanceof BlockNode blockNode) {
            var descriptor = blockNode.descriptor;
            var blockFrame = Truffle.getRuntime().createVirtualFrame(new Object[]{frame.materialize()}, descriptor);
            return elseBlock.execute(blockFrame);
        }else {
            return elseBlock.execute(frame);
        }
    }
}
