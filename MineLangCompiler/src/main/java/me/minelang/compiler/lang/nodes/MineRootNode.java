package me.minelang.compiler.lang.nodes;

import com.oracle.truffle.api.CompilerAsserts;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.api.nodes.RootNode;
import me.minelang.compiler.lang.MineContext;
import me.minelang.compiler.lang.MineLanguage;

import java.util.Arrays;

@NodeInfo(language = "MineLang", shortName = "RootNode", description = "the node for executing")
public final class MineRootNode extends RootNode {
    @Children
    private final MineNode[] bodyNodes;
    private final boolean hasLanguagePolyglot;

    public MineRootNode(MineLanguage language, MineNode[] bodyNodes, FrameDescriptor frameDescriptor) {
        super(language, frameDescriptor);
        this.bodyNodes = bodyNodes;
        this.hasLanguagePolyglot = language != null;
    }

    public MineRootNode(FrameDescriptor frameDescriptor, MineNode... bodyNodes) {
        super(null, frameDescriptor);
        this.bodyNodes = bodyNodes;
        this.hasLanguagePolyglot = false;
    }

    public MineRootNode(MineLanguage language, MineNode... bodyNodes) {
        super(language);
        this.bodyNodes = bodyNodes;
        this.hasLanguagePolyglot = language != null;
    }

    public MineRootNode(MineNode... bodyNodes) {
        super(null);
        this.bodyNodes = bodyNodes;
        this.hasLanguagePolyglot = false;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        // 保存根栈帧，用于全局变量和全局函数
        if (hasLanguagePolyglot) {
            var ctx = MineContext.get(this);
            ctx.setRootFrame(frame.materialize());
            ctx.initersImplement(); //初始化内建环境
        }
        // 遍历执行每一项
        int last = this.bodyNodes.length - 1;
        CompilerAsserts.compilationConstant(last);
        for (int i = 0; i < last; i++) {
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
