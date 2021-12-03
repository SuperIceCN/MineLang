package me.minelang.tests.language;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Engine;
import org.graalvm.polyglot.Value;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class ParserTest {
    private Engine engine = null;

    public Value eval(String code) {
        engine = engine == null ? Engine.newBuilder().build() : engine;
        var ctx = Context.newBuilder().engine(engine).build();
        return ctx.eval("MineLang", code);
    }

    @Test
    public void testParse1() {
        Assert.assertEquals("result: 34.5", eval("""
                a = 10 + 24.5
                b = a = 'result: ' + a
                b
                """).toString());
    }

    @Test
    public void testParse2() {
        Assert.assertEquals(16f, eval("""
                a = (1 + 2) * 3 / 2
                b = a / 0.25
                b
                """).asFloat(), 0.0001f);
    }

    @Test
    public void testParse3() {
        Assert.assertEquals("a: 9.0; b: 10.0", eval("""
                a = (1 + 2) * 4.5
                b = (a = a / 1.5) + 1
                "a: " + a + '; b: ' + b
                """).toString());
    }

    @Test
    public void testParse4() {
        var codes = new String[100];
        var random = new Random();
        for (var i = 0; i < 100; i++) {
            codes[i] = """
                    a = (%d + %d) * %f
                    b = (a = a / %f) + %d
                    "a: " + a + '; b: ' + b
                    """.formatted(random.nextInt(), random.nextInt(), random.nextFloat(), random.nextFloat(), random.nextInt());
        }
        long start = System.currentTimeMillis();
        for (var i = 0; i < 100; i++) {
            eval(codes[i]);
        }
        long end = System.currentTimeMillis();

        System.out.println("Time average: " + (end - start) / 100.0 + "ms");
    }

    @Test
    public void testParse5() {
        Assert.assertEquals(5.1f, eval("""
                a = {1.70 * 3}
                a
                """).asFloat(), 0.00001f);
    }

    @Test
    public void testParse6() {
        Assert.assertEquals(5.1f, eval("""
                a = {
                    b = 1.70
                    b * 3
                }
                a
                """).asFloat(), 0.00001f);
    }

    @Test
    public void testParse7() {
        Assert.assertEquals("c: 22.33", eval("""
                b = 22.33
                a = {
                    c = b
                    b = 1.70
                    b * 3
                    'c: ' + c
                }
                a
                """).toString());
    }

    @Test
    public void testParse8() {
        Assert.assertEquals("false", eval("""
                b = 22.33 >= 33.22
                """).toString());
    }

    @Test
    public void testParse9() {
        Assert.assertEquals("lwr", eval("""
                b = 22.33 >= 33.22
                a = if b 'gtr' else 'lwr'
                """).toString());
    }

    @Test
    public void testParse10() {
        Assert.assertEquals("Goodbye world!", eval("""
                a = "hello world"
                b = if a == 'Hello world!' {
                    'Nice day!'
                }else if a == 'hello world!' {
                    'Correct!'
                }else {
                    a = 'Goodbye'
                    a = a + ' ' + "world"
                    a + "!"
                }
                b
                """).toString());
    }

    @Test
    public void testParse11() {
        Assert.assertEquals(64, eval("""
                {
                a = 2 //2
                a = a * 2 //4
                a = a + 1 //5
                a = a / 5 //1
                a = a * 7 //7
                a = a * 4 //28
                a = a / 2 //14
                a = a + 6 //20
                a = a / 5 //4
                a = a - 7 //-3
                a = a * 9 //-27
                a = a + 3 //-24
                a = a - (-6) //-18
                a = a / 9 //-2
                a = a + 3 //1
                a = a - 3 //-2
                a = a + 8 //6
                a = a + 14 //20
                a = a * 5 //100
                a = a - 77 //23
                a = a + 3 //26
                a = a / 2 //13
                a = a - 5 //8
                a = a * 2 //16
                a = a - 4 //12
                a = a + 2 //14
                a = a / 7 //2
                a = a - 4 //-2
                a = a * (-3) //6
                a = a + 18 //24
                a = a - 8 //16
                a = a + 3 //19
                a = a * 2 //38
                a = a - 0 //38
                a = a + 2 //40
                a = a / 10 //4
                a = a - 1 //3
                a = a + 1 //4
                a = a * 16 //64
                }
                """).asInt());
    }

    @Test
    public void testParse12() {
        Assert.assertEquals("hello world", eval("""
                print("hello world")
                """).toString());
    }

    @Test
    public void testParse13() {
        Assert.assertEquals("undefined", eval("""
                (func _(){
                    return;
                })();
                """).toString());
    }

    @Test
    public void testParse14() {
        Assert.assertEquals(0, eval("""
                return 0
                """).asInt());
    }
}
