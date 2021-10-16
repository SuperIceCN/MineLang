package me.minelang.compiler.lang.nodes.literial;

import com.oracle.truffle.api.dsl.NodeField;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;

@NodeInfo(language = "MineLang", shortName = "boolLiteral", description = "")
@NodeField(name = "value", type = Boolean.class)
public abstract class BoolLiteralNode extends AbstractLiteralNode {
    @Specialization
    public abstract boolean getValue();
}
