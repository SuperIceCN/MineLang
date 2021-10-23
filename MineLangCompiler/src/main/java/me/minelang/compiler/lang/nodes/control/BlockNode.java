package me.minelang.compiler.lang.nodes.control;

import com.oracle.truffle.api.CompilerAsserts;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.NodeInfo;
import me.minelang.compiler.lang.nodes.MineNode;

@NodeInfo(language = "MineLang", shortName = "block", description = "A statements block.")
public final class BlockNode extends MineNode {
    @Children final MineNode[] bodyNodes;
    public final FrameDescriptor descriptor;

    BlockNode(FrameDescriptor descriptor, MineNode[] nodes) {
        this.descriptor = descriptor;
        this.bodyNodes = nodes;
    }

    @Override
    @ExplodeLoop
    public Object execute(VirtualFrame frame) {
        var last = this.bodyNodes.length - 1;
        CompilerAsserts.partialEvaluationConstant(last);
        for (var i=0; i<last; i++) {
            this.bodyNodes[i].execute(frame);
        }
        return this.bodyNodes[last].execute(frame);
    }
}
