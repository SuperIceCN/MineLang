package me.minelang.compiler.lang.nodes.literial;

import com.oracle.truffle.api.dsl.NodeField;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;
import me.minelang.compiler.lang.types.MineBigInteger;

@NodeInfo(language = "MineLang", shortName = "bigIntegerLiteral", description = "")
@NodeField(name = "value", type = MineBigInteger.class)
public abstract class BigIntegerLiteralNode extends AbstractNumberLiteralNode {
    @Specialization
    public abstract MineBigInteger getValue();

    @Override
    public abstract MineBigInteger executeMineBigInteger(VirtualFrame frame);
}
