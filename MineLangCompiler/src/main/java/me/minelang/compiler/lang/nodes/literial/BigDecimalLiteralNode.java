package me.minelang.compiler.lang.nodes.literial;

import com.oracle.truffle.api.dsl.NodeField;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;
import me.minelang.compiler.lang.types.MineBigDecimal;

@NodeInfo(language = "MineLang", shortName = "bigDecimalLiteral", description = "")
@NodeField(name = "value", type = MineBigDecimal.class)
public abstract class BigDecimalLiteralNode extends AbstractNumberLiteralNode {
    @Specialization
    public abstract MineBigDecimal getValue();

    @Override
    public abstract MineBigDecimal executeMineBigDecimal(VirtualFrame frame);
}
