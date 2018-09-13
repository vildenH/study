package study;

import org.joda.time.DateTime;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

/**
 * @author wh
 * @date 2018/9/13
 */
// 输出结果的时间粒度为微秒
@OutputTimeUnit(TimeUnit.NANOSECONDS)
// 测试方法平均执行时间
@BenchmarkMode(Mode.AverageTime)
// @Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
// @Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
public class testJoda {

    static int millis = 24 * 3600 * 1000;

    public static void main(String[] args) throws Exception {
        Options options = new OptionsBuilder().include(testJoda.class.getName()).forks(1).build();
        new Runner(options).run();
    }

    @Benchmark
    @Threads(16)
    public long runCalendar() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTimeInMillis();
    }

    @Benchmark
    @Threads(16)
    public long runJoda() {
        DateTime dateTime = new DateTime();
        return dateTime.getMillis();
    }

    //
    @Benchmark
    @Threads(16)
    public long runSystem() {
        return System.currentTimeMillis() / millis;

    }
}
