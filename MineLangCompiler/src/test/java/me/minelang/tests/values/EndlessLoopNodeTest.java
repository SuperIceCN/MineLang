package me.minelang.tests.values;

import me.minelang.tests.TestUtil;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Engine;
import org.graalvm.polyglot.Value;
import org.junit.Assert;
import org.junit.Test;

public class EndlessLoopNodeTest {
    private Engine engine = null;

    public Value eval(String code) {
        engine = engine == null ? Engine.newBuilder().build() : engine;
        var ctx = Context.newBuilder().engine(engine).build();
        return ctx.eval("MineLang", code);
    }

    @Test
    public void testLoop1() {
        Assert.assertEquals(5, eval("""
                a = 0
                loop {
                    global a
                    if a < 5 a = a + 1 else break a
                }
                """).asInt());
    }

    @Test
    public void testLoop2() {
        Assert.assertEquals("undefined", eval("""
                loop break
                """).toString());
    }

    @Test
    public void testLoop3() {
        Assert.assertEquals("280571172992510140037611932413038677189525", eval("""
                x1 = 1
                x2 = 1
                index = 2
                loop {
                    global x1, x2, index
                    index = index + 1
                    x3 = x1 + x2
                    x1 = x2
                    x2 = x3
                    if index == 200 break x3
                }
                """).toString());
    }

    @Test
    public void testLoop4() {
        var result = TestUtil.warmUpExactly("O(n)斐波那契数列第30000项", 15, () -> eval("""
                x1 = 1
                x2 = 1
                index = 2
                loop {
                    global x1, x2, index
                    index = index + 1
                    x3 = x1 + x2
                    x1 = x2
                    x2 = x3
                    if index == 30000 break x3
                }
                """));
        System.out.println(result);
    }
}
