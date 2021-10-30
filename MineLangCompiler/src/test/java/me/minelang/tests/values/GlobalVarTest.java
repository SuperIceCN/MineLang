package me.minelang.tests.values;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Engine;
import org.graalvm.polyglot.Value;
import org.junit.Assert;
import org.junit.Test;

public class GlobalVarTest {
    private Engine engine = null;

    public Value eval(String code) {
        engine = engine == null ? Engine.newBuilder().build() : engine;
        var ctx = Context.newBuilder().engine(engine).build();
        return ctx.eval("MineLang", code);
    }

    @Test
    public void testGlobalVar1() {
        Assert.assertEquals(3, eval("""
                a = 2
                if a < 3 {
                    global a
                    a = a + 1
                }else {
                    global a
                    a = a - 1
                }
                a
                """).asInt());
    }
}
