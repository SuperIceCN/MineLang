package me.minelang.tests.values;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Engine;
import org.graalvm.polyglot.Value;
import org.junit.Test;

public class VarSlotKindTest {
    private Engine engine = null;

    public Value eval(String code) {
        engine = engine == null ? Engine.newBuilder().build() : engine;
        var ctx = Context.newBuilder().engine(engine).build();
        return ctx.eval("MineLang", code);
    }

    @Test
    public void testSlotKind1() {
        System.out.println(eval("""
                a = 2
                a = 333
                a = 'ok'
                a = a + 3.4
                a = 7
                a = 99.9
                a = 22332233223322332233223322332233223322332233223322332233
                """));
    }
}
