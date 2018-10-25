package study;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.springframework.util.AntPathMatcher;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 */
// 输出结果的时间粒度为微秒
@OutputTimeUnit(TimeUnit.NANOSECONDS)
// 测试方法平均执行时间
@BenchmarkMode(Mode.AverageTime)
// 测试方法进程数
@Fork(1)
public class testAntPathMatcher {

    public static void main(String[] args) throws Exception {
        Options options = new OptionsBuilder().include(testJoda.class.getName()).forks(1).build();
        new Runner(options).run();
    }

    public List<String> getNotFilterPathPatterns() {
        return Arrays.asList("/api/**", "/unauthorized", "favicon.ico");
    }

    static AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Benchmark
    public boolean testAntMatcher() {
        return Arrays.asList("/api/**", "/unauthorized", "/favicon.ico").stream().anyMatch(pattern -> antPathMatcher.match(pattern, "/api/monitor/alive"));
    }


    @Benchmark
    public void test() {
        // This is a demo/sample template for building your JMH benchmarks. Edit as needed.
        // Put your benchmark code here.
        // Put your benchmark code here.
        int a = 1;
        int b = 2;
        int sum = a + b;
    }

}
