package me.minelang.compiler.lang.nodes.literial;

import com.oracle.truffle.api.dsl.NodeField;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;

@NodeInfo(language = "MineLang", shortName = "FloatLiteralNode", description = "")
@NodeField(name = "value", type = float.class)
public abstract class FloatLiteralNode extends AbstractNumberLiteralNode{
    @Specialization
    public abstract float getValue();
}
