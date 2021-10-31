package me.minelang.tests.values;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Engine;
import org.graalvm.polyglot.PolyglotException;
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


    @Test
    public void testGlobalVar2() {
        try {
            eval("""
                    a = 1
                    {
                        global b
                        b
                    }
                    """);
        } catch (PolyglotException e) {
            //ignore
        }
    }

    @Test
    public void testGlobalVar3() {
        Assert.assertEquals(5, eval("""
                a = 1
                {
                    global a, b
                    a = a + 1
                    b = 3 + a
                }
                b
                """).asInt());
    }

    @Test
    public void testGlobalVar4() {
        Assert.assertEquals(2, eval("""
                {
                    global a
                    a = 2
                }
                a
                """).asInt());
    }
}
