package study;

import org.apache.commons.lang3.RandomStringUtils;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import test.EncryptHelper;

import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 */
// 输出结果的时间粒度为微秒
@OutputTimeUnit(TimeUnit.MILLISECONDS)
// 测试方法平均执行时间
@BenchmarkMode(Mode.AverageTime)
// 测试方法进程数
@Fork(1)
public class App {

    public static void main(String[] args) throws Exception {
        Options options = new OptionsBuilder().include(testJoda.class.getName()).forks(1).build();
        new Runner(options).run();
    }

    @Benchmark
    public String testEncrypt() {
        String content = RandomStringUtils.randomNumeric(32);
        String encry = EncryptHelper.encrypt256AesWithSalt(content, "qdb.trade.center");
        return encry;
    }


    @Benchmark
    public void testMethod() {
        // This is a demo/sample template for building your JMH benchmarks. Edit as needed.
        // Put your benchmark code here.
        // Put your benchmark code here.
        int a = 1;
        int b = 2;
        int sum = a + b;
    }

}
