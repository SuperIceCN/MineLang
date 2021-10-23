package me.minelang.compiler.lang.nodes;

import com.oracle.truffle.api.CompilerAsserts;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.api.nodes.RootNode;
import me.minelang.compiler.lang.MineLanguage;

import java.util.Arrays;

@NodeInfo(language = "MineLang", shortName = "RootNode", description = "the node for executing")
public class MineRootNode extends RootNode {
    @Children private final MineNode[] bodyNodes;

    public MineRootNode(MineLanguage language, MineNode[] bodyNodes, FrameDescriptor frameDescriptor) {
        super(language, frameDescriptor);
        this.bodyNodes = bodyNodes;
    }

    public MineRootNode(FrameDescriptor frameDescriptor, MineNode... bodyNodes) {
        super(null, frameDescriptor);
        this.bodyNodes = bodyNodes;
    }

    public MineRootNode(MineLanguage language, MineNode... bodyNodes) {
        super(language);
        this.bodyNodes = bodyNodes;
    }

    public MineRootNode(MineNode... bodyNodes){
        super(null);
        this.bodyNodes = bodyNodes;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        int last = this.bodyNodes.length - 1;
        CompilerAsserts.compilationConstant(last);
        for (int i=0; i<last; i++) {
            this.bodyNodes[i].execute(frame);
        }
        return this.bodyNodes[last].execute(frame);
    }

    @Override
    public String toString() {
        CompilerAsserts.neverPartOfCompilation();
        return Arrays.toString(this.bodyNodes);
    }
}
