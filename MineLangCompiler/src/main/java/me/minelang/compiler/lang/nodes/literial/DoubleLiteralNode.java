package me.minelang.compiler.lang.nodes.literial;

import com.oracle.truffle.api.dsl.NodeField;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;

@NodeInfo(language = "MineLang", shortName = "doubleLiteral", description = "")
@NodeField(name = "value", type = double.class)
public abstract class DoubleLiteralNode extends AbstractNumberLiteralNode {
    @Specialization
    public abstract double getValue();
}
