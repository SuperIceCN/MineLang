package me.minelang.compiler.lang.nodes.literial;

import com.oracle.truffle.api.dsl.NodeField;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;

@NodeInfo(language = "MineLang", shortName = "byteLiteral", description = "")
@NodeField(name = "value", type = String.class)
public abstract class StringLiteralNode extends AbstractLiteralNode {
    @Specialization
    public abstract String getValue();
    @Override
    public abstract String executeString(VirtualFrame frame);
}
