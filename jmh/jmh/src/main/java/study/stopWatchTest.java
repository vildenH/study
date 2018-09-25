package study;

import com.google.common.base.Stopwatch;
import org.apache.commons.lang3.time.StopWatch;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author wh
 * @date 2018/9/25
 */

// 输出结果的时间粒度为微秒
@OutputTimeUnit(TimeUnit.NANOSECONDS)
// 测试方法平均执行时间
@BenchmarkMode(Mode.AverageTime)
// 测试方法进程数
@Fork(1)
public class stopWatchTest {
    public static void main(String[] args) throws Exception {
        Options options = new OptionsBuilder().include(stopWatchTest.class.getName()).forks(1).build();
        new Runner(options).run();
    }

    @Benchmark
    public long testApache() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        stopWatch.stop();
        return stopWatch.getTime();
    }


    @Benchmark
    public long testGuava() {
        Stopwatch stopWatch = Stopwatch.createStarted();
        return stopWatch.elapsed(TimeUnit.MILLISECONDS);
    }
}
