package me.minelang.compiler.lang;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.dsl.ImplicitCast;
import com.oracle.truffle.api.dsl.TypeCast;
import com.oracle.truffle.api.dsl.TypeCheck;
import com.oracle.truffle.api.dsl.TypeSystem;
import me.minelang.compiler.lang.types.*;

import java.math.BigInteger;

@TypeSystem({
        boolean.class,
        byte.class, short.class, int.class, long.class, MineBigInteger.class, float.class, double.class, MineBigDecimal.class,
        String.class, MineFunction.class, MineNone.class, MineNan.class
})
public abstract class MineTypeSystem {
    @ImplicitCast
    @CompilerDirectives.TruffleBoundary(allowInlining = true)
    public static short castByteToShort(byte aByte) {
        return aByte;
    }

    @ImplicitCast
    @CompilerDirectives.TruffleBoundary(allowInlining = true)
    public static int castByteToInt(byte aByte) {
        return aByte;
    }

    @ImplicitCast
    @CompilerDirectives.TruffleBoundary(allowInlining = true)
    public static long castByteToLong(byte aByte) {
        return aByte;
    }

    @ImplicitCast
    @CompilerDirectives.TruffleBoundary(allowInlining = true)
    public static MineBigInteger castByteToBigInteger(byte aByte) {
        return new MineBigInteger(BigInteger.valueOf(aByte));
    }

    @ImplicitCast
    @CompilerDirectives.TruffleBoundary(allowInlining = true)
    public static float castByteToFloat(byte aLong) {
        return aLong;
    }

    @ImplicitCast
    @CompilerDirectives.TruffleBoundary(allowInlining = true)
    public static double castByteToDouble(byte aLong) {
        return aLong;
    }

    @ImplicitCast
    @CompilerDirectives.TruffleBoundary(allowInlining = true)
    public static MineBigDecimal castByteToBigDecimal(byte aByte) {
        return new MineBigDecimal(BigInteger.valueOf(aByte));
    }

    @ImplicitCast
    @CompilerDirectives.TruffleBoundary(allowInlining = true)
    public static int castShortToInt(short aShort) {
        return aShort;
    }

    @ImplicitCast
    @CompilerDirectives.TruffleBoundary(allowInlining = true)
    public static long castShortToLong(short aShort) {
        return aShort;
    }

    @ImplicitCast
    @CompilerDirectives.TruffleBoundary(allowInlining = true)
    public static MineBigInteger castShortToBigInteger(short aShort) {
        return new MineBigInteger(BigInteger.valueOf(aShort));
    }

    @ImplicitCast
    @CompilerDirectives.TruffleBoundary(allowInlining = true)
    public static float castShortToFloat(short aLong) {
        return aLong;
    }

    @ImplicitCast
    @CompilerDirectives.TruffleBoundary(allowInlining = true)
    public static double castShortToDouble(short aLong) {
        return aLong;
    }

    @ImplicitCast
    @CompilerDirectives.TruffleBoundary(allowInlining = true)
    public static MineBigDecimal castShortToBigDecimal(short aShort) {
        return new MineBigDecimal(BigInteger.valueOf(aShort));
    }

    @ImplicitCast
    @CompilerDirectives.TruffleBoundary(allowInlining = true)
    public static long castIntToLong(int aInt) {
        return aInt;
    }

    @ImplicitCast
    @CompilerDirectives.TruffleBoundary(allowInlining = true)
    public static MineBigInteger castIntToBigInteger(int aInt) {
        return new MineBigInteger(BigInteger.valueOf(aInt));
    }

    @ImplicitCast
    @CompilerDirectives.TruffleBoundary(allowInlining = true)
    public static float castIntToFloat(int aLong) {
        return aLong;
    }

    @ImplicitCast
    @CompilerDirectives.TruffleBoundary(allowInlining = true)
    public static double castIntToDouble(int aLong) {
        return aLong;
    }

    @ImplicitCast
    @CompilerDirectives.TruffleBoundary(allowInlining = true)
    public static MineBigDecimal castIntToBigDecimal(int aInt) {
        return new MineBigDecimal(BigInteger.valueOf(aInt));
    }

    @ImplicitCast
    @CompilerDirectives.TruffleBoundary(allowInlining = true)
    public static MineBigInteger castLongToMineBigInteger(long aLong) {
        return new MineBigInteger(aLong);
    }

    @ImplicitCast
    @CompilerDirectives.TruffleBoundary(allowInlining = true)
    public static double castMineBigIntegerToDouble(MineBigInteger bigInteger) {
        return bigInteger.getValue().doubleValue();
    }

    @ImplicitCast
    @CompilerDirectives.TruffleBoundary(allowInlining = true)
    public static double castLongToDouble(long aLong) {
        return aLong;
    }

    @ImplicitCast
    @CompilerDirectives.TruffleBoundary(allowInlining = true)
    public static float castLongToFloat(long aLong) {
        return aLong;
    }

    @ImplicitCast
    @CompilerDirectives.TruffleBoundary(allowInlining = true)
    public static double castFloatToDouble(float aLong) {
        return aLong;
    }

    @ImplicitCast
    @CompilerDirectives.TruffleBoundary(allowInlining = true)
    public static MineBigDecimal castFloatToBigDecimal(float aLong) {
        return new MineBigDecimal(aLong);
    }

    @ImplicitCast
    @CompilerDirectives.TruffleBoundary(allowInlining = true)
    public static MineBigDecimal castLongToBigDecimal(long aLong) {
        return new MineBigDecimal(aLong);
    }

    @ImplicitCast
    @CompilerDirectives.TruffleBoundary(allowInlining = true)
    public static MineBigDecimal castDoubleToBigDecimal(double aDouble) {
        return new MineBigDecimal(aDouble);
    }

    @ImplicitCast
    @CompilerDirectives.TruffleBoundary(allowInlining = true)
    public static MineBigDecimal castMineBigIntegerToBigDecimal(MineBigInteger bigInteger){
        return new MineBigDecimal(bigInteger.getValue());
    }

    /*
     * 只有唯一的单例才是合法的MineNone
     */
    @TypeCheck(MineNone.class)
    public static boolean isMineNone(Object value){
        return value == MineNone.SINGLETON;
    }

    /*
     * 让Truffle不要自己瞎生成强转，用我们的单例，大大的👌
     */
    @TypeCast(MineNone.class)
    public static MineNone asMineNone(Object value){
        assert isMineNone(value);
        return MineNone.SINGLETON;
    }

    @TypeCheck(MineNan.class)
    public static boolean isMineNan(Object value){
        if(value == MineNan.SINGLETON) return true;
        else if(value instanceof Float f) return Float.isNaN(f);
        else if(value instanceof Double d) return Double.isNaN(d);
        return false;
    }

    /*
     * 同上
     */
    @TypeCast(MineNan.class)
    public static MineNan asMineNan(Object value){
        assert isMineNone(value);
        return MineNan.SINGLETON;
    }

}
