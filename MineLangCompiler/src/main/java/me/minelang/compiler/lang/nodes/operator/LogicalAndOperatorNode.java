package me.minelang.compiler.lang.nodes.operator;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;
import me.minelang.compiler.lang.nodes.MineNode;

@NodeInfo(language = "MineLang", shortName = "&&", description = "operatorLogicalAnd")
@NodeChild(value = "left", type = MineNode.class)
@NodeChild(value = "right", type = MineNode.class)
public abstract class LogicalAndOperatorNode extends AbstractOperatorNode{
    @Specialization
    boolean and(boolean a, boolean b) {
        return a && b;
    }
}
