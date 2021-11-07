package me.minelang.tests;

import org.apache.commons.math3.stat.descriptive.rank.Median;
import org.apache.commons.math3.stat.descriptive.summary.Sum;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Engine;
import org.graalvm.polyglot.Value;

import java.util.Arrays;

public final class TestUtil {
    public static double warmUpAverage(int executeTime, TestWorker test) {
        var start = System.currentTimeMillis();
        for (var i = 0; i < executeTime; i++)
            test.run();
        return (System.currentTimeMillis() - start) / ((double) executeTime);
    }

    public static double warmUpMedian(int executeTime, TestWorker test) {
        var data = new Median();
        var times = new double[executeTime];
        long start;
        for (var i = 0; i < executeTime; i++) {
            start = System.currentTimeMillis();
            test.run();
            times[i] = System.currentTimeMillis() - start;
        }
        data.setData(times);
        return data.evaluate();
    }

    public static TestResult warmUpExactly(String name, int executeTime, TestWorker test) {
        var times = new double[executeTime];
        long start;
        for (var i = 0; i < executeTime; i++) {
            start = System.currentTimeMillis();
            test.run();
            times[i] = System.currentTimeMillis() - start;
        }
        var sum = new Sum();sum.setData(times);
        var total = sum.evaluate();
        var average = total / executeTime;
        var median = new Median();median.setData(times);
        return new TestResult(name, times, total, average, median.evaluate());
    }

    private static Engine engine = null;

    public static Value eval(String code) {
        engine = engine == null ? Engine.newBuilder().build() : engine;
        var ctx = Context.newBuilder().engine(engine).build();
        return ctx.eval("MineLang", code);
    }

    public interface TestWorker {
        void run();
    }

    public record TestResult(String name, double[] times,double total, double average, double median){
        @Override
        public String toString() {
            return """
                    %s 测试结果：
                    运行次数 %d / 总耗时 %.2fms / 平均耗时 %.2fms / 中位数 %.2fms
                    详情：
                    %s
                    """.formatted(name, times.length, total, average, median, Arrays.toString(times));
        }
    }
}
