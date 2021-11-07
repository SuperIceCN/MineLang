package me.minelang.tests.values;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Engine;
import org.graalvm.polyglot.Value;
import org.junit.Assert;
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
        Assert.assertEquals(2, eval("""
                a = func get2(){
                    2
                }
                a()
                """).asInt());
    }

    @Test
    public void testFunction2() {
        Assert.assertEquals(2, eval("""
                func get2(){
                    2
                }
                get2()
                """).asInt());
    }

    @Test
    public void testFunction3() {
        Assert.assertEquals(55, eval("""
                func sum(a, b) {a+b}
                sum(1, sum(2, sum(3, sum(4, sum(5, sum(6, sum(7, sum(8, sum(9, 10)))))))))
                """).asInt());
    }

    @Test
    public void testFunction4() {
        Assert.assertEquals("280571172992510140037611932413038677189525", eval("""
                func 斐波那契(项数) {
                    func 计算(需求项数, 当前项数, 前两项, 前一项) {
                        下一项项数 = 当前项数 + 1
                        当前项内容 = 前一项
                        下一项内容 = 前一项 + 前两项
                        if(需求项数 == 当前项数) {
                            前一项 + 前两项
                        }else {
                            计算(需求项数, 下一项项数, 当前项内容, 下一项内容)
                        }
                    }
                    计算(项数, 3, 1, 1)
                }
                斐波那契(200)
                """).toString());
    }

    @Test
    public void testFunction5() {
        Assert.assertEquals("ok", eval("""
                func a(arg) {
                    if arg == 0 'ok' else a(arg - 1)
                }
                a(200)
                """).toString());
    }

    @Test
    public void testFunction6() {
        Assert.assertEquals(3628800, eval("""
                func 阶乘(项数) {
                    func 计算(当前项数) {
                        if 当前项数 != 1 {
                            return 当前项数 * 计算(当前项数 - 1)
                        } else {
                            return 1
                        }
                    }
                    计算(项数)
                }
                阶乘(10)
                """).asInt());
    }
}
