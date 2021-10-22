package me.minelang.compiler.lang.nodes.operator;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;
import me.minelang.compiler.lang.nodes.MineNode;

@NodeInfo(language = "MineLang", shortName = "!", description = "operatorLogicalNot")
@NodeChild(value = "value", type = MineNode.class)
public abstract class LogicalNotOperatorNode extends AbstractOperatorNode{
    @Specialization
    boolean not(boolean a) {
        return !a;
    }
}
