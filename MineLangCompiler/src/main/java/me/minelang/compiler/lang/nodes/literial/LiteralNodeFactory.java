package me.minelang.compiler.lang.nodes.literial;

import me.minelang.compiler.lang.types.MineBigDecimal;
import me.minelang.compiler.lang.types.MineBigInteger;

import java.math.BigDecimal;
import java.math.BigInteger;

public final class LiteralNodeFactory {
    private static final LiteralNodeFactory INSTANCE = new LiteralNodeFactory();

    public StringLiteralNode createStringNode(String literal){
        return StringLiteralNodeFactory.create(literal);
    }

    public AbstractNumberLiteralNode createNumberNode(String number){
        if(number.indexOf('.')!=-1){ //没有小数点
            var len = number.length();
            var r1 = Float.parseFloat(number);
            /*
             * 8 和 17 在这里是经验数字，通常超出它们所表述的长度范围的字符串都不满足当前精度要求
             * 所以我们将这样的值提升一个精度以尽可能确保运算正确性
             */
            if (!(r1 >= Float.MAX_VALUE) && !(r1 <= Float.MIN_VALUE) && len <= 8) {
                return FloatLiteralNodeFactory.create(r1);
            }
            var r2 = Double.parseDouble(number);
            if (!(r2 >= Double.MAX_VALUE) && !(r2 <= Double.MIN_VALUE) && len <= 17) {
                return DoubleLiteralNodeFactory.create(r2);
            }
            //全都不满足时使用高精度计算，但会显著降低计算速度，所以我们尽量使用浮点数
            return BigDecimalLiteralNodeFactory.create(new MineBigDecimal(new BigDecimal(number)));
        }else {
            try {
                return ByteLiteralNodeFactory.create(Byte.parseByte(number));
            }catch (NumberFormatException e1){
                try {
                    return ShortLiteralNodeFactory.create(Short.parseShort(number));
                }catch (NumberFormatException e2){
                    try {
                        return IntLiteralNodeFactory.create(Integer.parseInt(number));
                    }catch (NumberFormatException e3){
                        try {
                            return LongLiteralNodeFactory.create(Long.parseLong(number));
                        }catch (NumberFormatException e4){
                            return BigIntegerLiteralNodeFactory.create(new MineBigInteger(new BigInteger(number)));
                        }
                    }
                }
            }
        }
    }

    public static LiteralNodeFactory getInstance() {
        return INSTANCE;
    }
}
