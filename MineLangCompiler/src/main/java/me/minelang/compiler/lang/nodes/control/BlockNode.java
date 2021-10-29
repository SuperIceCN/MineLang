package me.minelang.compiler.lang.nodes.control;

import com.oracle.truffle.api.CompilerAsserts;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.NodeInfo;
import me.minelang.compiler.lang.nodes.MineNode;

@NodeInfo(language = "MineLang", shortName = "block", description = "A statements block.")
public final class BlockNode extends MineNode {
    @Children
    final MineNode[] bodyNodes;
    public final FrameDescriptor descriptor;
    /**
     * 是否使用内部帧，如果启用将默认execute中传入的帧为父级帧并创建一个新帧作为执行帧
     */
    public final boolean useInnerFrame;

    BlockNode(FrameDescriptor descriptor, MineNode[] nodes) {
        this.descriptor = descriptor;
        this.bodyNodes = nodes;
        this.useInnerFrame = false;
    }

    public BlockNode(FrameDescriptor descriptor, MineNode[] bodyNodes, boolean useInnerFrame) {
        this.bodyNodes = bodyNodes;
        this.descriptor = descriptor;
        this.useInnerFrame = useInnerFrame;
    }

    @Override
    @ExplodeLoop
    public Object execute(VirtualFrame frame) {
        CompilerAsserts.partialEvaluationConstant(this.bodyNodes.length);
        var last = this.bodyNodes.length - 1;
        CompilerAsserts.partialEvaluationConstant(last);
        VirtualFrame virtualFrame = null;
        if (useInnerFrame) {
            virtualFrame = Truffle.getRuntime().createVirtualFrame(new Object[]{frame.materialize()}, this.descriptor);
        }
        CompilerAsserts.compilationConstant(virtualFrame);
        for (var i = 0; i < last; i++) {
            this.bodyNodes[i].execute(useInnerFrame ? virtualFrame : frame);
        }
        return this.bodyNodes[last].execute(useInnerFrame ? virtualFrame : frame);
    }
}
