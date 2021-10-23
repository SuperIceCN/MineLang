package me.minelang.compiler.lang.nodes.control;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;
import me.minelang.compiler.lang.nodes.MineNode;

@NodeInfo(language = "MineLang", shortName = "ifElse", description = "if else")
public class IfElseNode extends MineNode {
    @Child public MineNode condition;
    @Children public MineNode[] branches;

    @Override
    public Object execute(VirtualFrame frame) {
        return null;
    }
}
