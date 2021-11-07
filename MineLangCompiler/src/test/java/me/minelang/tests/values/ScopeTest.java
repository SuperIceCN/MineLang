package me.minelang.tests.values;

import org.junit.Assert;
import org.junit.Test;

import static me.minelang.tests.TestUtil.eval;

public class ScopeTest {
    @Test
    public void testScope1() {
        Assert.assertEquals("1<->2", eval("""
                a = 1
                {
                    b = a
                    {
                        c = b
                        {
                            d = c
                            print(b + '<->' + (d + 1))
                        }
                    }
                }
                """).toString());
    }

    @Test
    public void testScope2() {
        Assert.assertEquals(100, eval("""
                func A(a){
                    func B(b)
                        if b >= 0 b + 1 else B(-b)
                    B(a)
                }
                A(-99)
                """).asInt());
    }

    @Test
    public void testScope3() {
        Assert.assertEquals(3628800, eval("""
                func factorial(index) {
                    func calc(currentIndex, currentValue) {
                        if currentIndex == 1 {
                            currentValue
                        } else {
                            calc(currentIndex - 1, currentValue * currentIndex)
                        }
                    }
                    calc(index, 1)
                }
                factorial(10)
                """).asInt());
    }
}
