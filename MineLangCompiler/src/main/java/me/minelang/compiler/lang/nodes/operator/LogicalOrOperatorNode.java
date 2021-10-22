package me.minelang.compiler.lang.nodes.operator;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;
import me.minelang.compiler.lang.nodes.MineNode;

@NodeInfo(language = "MineLang", shortName = "||", description = "operatorLogicalOr")
@NodeChild(value = "left", type = MineNode.class)
@NodeChild(value = "right", type = MineNode.class)
public abstract class LogicalOrOperatorNode extends AbstractOperatorNode{
    @Specialization
    boolean or(boolean a, boolean b) {
        return a || b;
    }
}
