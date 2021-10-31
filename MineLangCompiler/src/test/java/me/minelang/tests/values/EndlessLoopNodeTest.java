package me.minelang.tests.values;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Engine;
import org.graalvm.polyglot.Value;
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
        System.out.println(eval("""
                a = 0
                loop {
                    global a
                    if a < 5 a = a + 1 else break a
                }
                """));
    }

    @Test
    public void testLoop2() {
        System.out.println(eval("""
                loop break
                """));
    }

    @Test
    public void testLoop3() {
        System.out.println(eval("""
                x1 = 1
                x2 = 1
                index = 2
                loop {
                    global x1, x2, index
                    index = index + 1
                    x3 = x1 + x2
                    x1 = x2
                    x2 = x3
                    if index == 10 break x3
                }
                """));
    }
}
