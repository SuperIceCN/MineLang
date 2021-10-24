package me.minelang.compiler.lang.nodes.control;

import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.LoopNode;
import com.oracle.truffle.api.nodes.NodeInfo;
import me.minelang.compiler.lang.nodes.MineNode;

@NodeInfo(language = "MineLang", shortName = "loop", description = "A simple endless loop.")
public final class EndlessLoopNode extends MineNode {
    @Child
    LoopNode loopNode;

    private final MineNode bodyNode;

    EndlessLoopNode(MineNode bodyNode) {
        this.bodyNode = bodyNode;
        this.loopNode = Truffle.getRuntime().createLoopNode(new RepeatNode(EmptyNodeFactory.create(), bodyNode));
    }

    /*
     * 此处不用考虑正常退出后执行else块的问题，因为无限循环根本不会正常退出
     */
    @Override
    public Object execute(VirtualFrame frame) {
        if (bodyNode instanceof BlockNode blockNode) {
            var descriptor = blockNode.descriptor;
            var blockFrame = Truffle.getRuntime().createVirtualFrame(new Object[]{frame.materialize()}, descriptor);
            return ((LoopStatus) loopNode.execute(blockFrame)).result();
        } else {
            return ((LoopStatus) loopNode.execute(frame)).result();
        }
    }
}
