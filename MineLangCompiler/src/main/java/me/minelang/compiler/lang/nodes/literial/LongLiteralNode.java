package me.minelang.compiler.lang.nodes.literial;

import com.oracle.truffle.api.dsl.NodeField;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;

@NodeInfo(language = "MineLang", shortName = "longLiteral", description = "")
@NodeField(name = "value", type = long.class)
public abstract class LongLiteralNode extends AbstractNumberLiteralNode {
    @Specialization
    public abstract long getValue();
}
