package me.minelang.compiler.lang.nodes.literial;

import com.oracle.truffle.api.dsl.NodeField;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;

@NodeInfo(language = "MineLang", shortName = "byteLiteral", description = "")
@NodeField(name = "value", type = byte.class)
public abstract class ByteLiteralNode extends AbstractNumberLiteralNode {
    @Specialization
    public abstract byte getValue();
}
