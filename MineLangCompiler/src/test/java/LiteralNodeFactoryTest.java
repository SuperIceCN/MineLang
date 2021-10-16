import com.oracle.truffle.api.nodes.UnexpectedResultException;
import me.minelang.compiler.lang.nodes.literial.*;
import me.minelang.compiler.lang.types.MineBigDecimal;
import me.minelang.compiler.lang.types.MineBigInteger;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

public class LiteralNodeFactoryTest {
    @Test
    public void testStringNode() {
        var node = LiteralNodeFactory.getInstance().createStringNode("ok");
        System.out.println(node);
    }

    @Test
    public void testIntegerNode() throws UnexpectedResultException {
        var node = LiteralNodeFactory.getInstance().createNumberNode("1");
        Assert.assertTrue(node instanceof ByteLiteralNode);
        Assert.assertEquals(1, node.executeByte(null));

        node = LiteralNodeFactory.getInstance().createNumberNode("222");
        Assert.assertTrue(node instanceof ShortLiteralNode);
        Assert.assertEquals(222, node.executeShort(null));

        node = LiteralNodeFactory.getInstance().createNumberNode("88888");
        Assert.assertTrue(node instanceof IntLiteralNode);
        Assert.assertEquals(88888, node.executeInteger(null));

        node = LiteralNodeFactory.getInstance().createNumberNode("98765432123456789");
        Assert.assertTrue(node instanceof LongLiteralNode);
        Assert.assertEquals(98765432123456789L, node.executeLong(null));

        node = LiteralNodeFactory.getInstance().createNumberNode("9876543212345678987654321");
        Assert.assertTrue(node instanceof BigIntegerLiteralNode);
        Assert.assertEquals(new MineBigInteger(new BigInteger("9876543212345678987654321")), node.executeMineBigInteger(null));
    }

    @Test
    public void testDecimalNode() throws UnexpectedResultException {
        var node = LiteralNodeFactory.getInstance().createNumberNode("2.2");
        Assert.assertTrue(node instanceof FloatLiteralNode);
        Assert.assertEquals(2.2, node.executeFloat(null), 0.000001);

        node = LiteralNodeFactory.getInstance().createNumberNode("2.22222222222222");
        Assert.assertTrue(node instanceof DoubleLiteralNode);
        Assert.assertEquals(2.22222222222222, node.executeDouble(null), 0.000001);

        node = LiteralNodeFactory.getInstance().createNumberNode("2.222222222222222222222222222222222222222222222222");
        Assert.assertTrue(node instanceof BigDecimalLiteralNode);
        Assert.assertEquals(new MineBigDecimal(new BigDecimal("2.222222222222222222222222222222222222222222222222")), node.executeMineBigDecimal(null));
    }
}
