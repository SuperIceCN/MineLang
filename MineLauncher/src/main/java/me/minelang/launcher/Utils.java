package me.minelang.launcher;

import java.util.function.Consumer;
import java.util.function.Function;

public final class Utils {
    public static <t, r> r ok(t obj, Function<t, r> function, r ifNull) {
        return obj == null ? ifNull : function.apply(obj);
    }

    public static <t> void ok(t obj, Function<t, Boolean> guard ,Consumer<t> consumer) {
        if(guard.apply(obj)) {
            consumer.accept(obj);
        }
    }

    public static <t> void ok(t obj ,Consumer<t> consumer) {
        if(obj != null) {
            consumer.accept(obj);
        }
    }
}
