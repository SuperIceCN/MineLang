package me.minelang.compiler.lang.nodes.control;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;
import me.minelang.compiler.lang.nodes.MineNode;
import me.minelang.compiler.lang.types.MineNone;

@NodeInfo(language = "MineLang", shortName = "empty", description = "A node always returns a None.")
public final class EmptyNode extends MineNode {
    EmptyNode() {

    }

    @Override
    public Object execute(VirtualFrame frame) {
        return MineNone.SINGLETON;
    }

    @Override
    public MineNone executeNone(VirtualFrame frame) {
        return MineNone.SINGLETON;
    }
}
