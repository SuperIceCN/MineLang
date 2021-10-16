package me.minelang.compiler.lang.nodes.literial;

import com.oracle.truffle.api.dsl.NodeField;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;

@NodeInfo(language = "MineLang", shortName = "shortLiteral", description = "")
@NodeField(name = "value", type = short.class)
public abstract class ShortLiteralNode extends AbstractNumberLiteralNode {
    @Specialization
    public abstract short getValue();
}
