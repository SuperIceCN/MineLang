package me.minelang.tests.values;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Engine;
import org.graalvm.polyglot.Value;
import org.junit.Test;

public class FunctionNodeTest {
    private Engine engine = null;

    public Value eval(String code) {
        engine = engine == null ? Engine.newBuilder().build() : engine;
        var ctx = Context.newBuilder("MineLang").engine(engine).build();
        return ctx.eval("MineLang", code);
    }

    @Test
    public void testFunction1() {
        System.out.println(eval("""
                a = func get2(){
                    2
                }
                a()
                """));
    }
}
