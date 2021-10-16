package me.minelang.compiler.lang.nodes.literial;

import com.oracle.truffle.api.dsl.NodeField;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;

@NodeInfo(language = "MineLang", shortName = "intLiteral", description = "")
@NodeField(name = "value", type = int.class)
public abstract class IntLiteralNode extends AbstractNumberLiteralNode {
    @Specialization
    public abstract int getValue();
}
