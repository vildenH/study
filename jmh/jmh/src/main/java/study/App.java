package study;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import test.EncryptHelper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
public class App {

    public static void main(String[] args) throws Exception {
        Options options = new OptionsBuilder().include(study.testJoda.class.getName()).forks(1).build();
        new Runner(options).run();
    }

    @Benchmark
    public String testEncrypt() {
        String content = RandomStringUtils.randomNumeric(32);
        String encry = EncryptHelper.encrypt256AesWithSalt(content, "qdb.trade.center");
        return encry;
    }

    @Benchmark
    public String testApacheBase64() {
        return Base64.encodeBase64String(("123123123123123123asdasdasdsda" +
                "123123123123123123asdasdasdsda" +
                "123123123123123123asdasdasdsda" +
                "123123123123123123asdasdasdsda" +
                "123123123123123123asdasdasdsda" +
                "123123123123123123asdasdasdsda").getBytes());
    }

    @Benchmark
    public String testJdk8Base64() {
        return java.util.Base64.getEncoder().encodeToString(("123123123123123123asdasdasdsda" +
                "123123123123123123asdasdasdsda" +
                "123123123123123123asdasdasdsda" +
                "123123123123123123asdasdasdsda" +
                "123123123123123123asdasdasdsda").getBytes());
    }

    @Benchmark
    public CloseableHttpClient testHttpClients() {
        return HttpClients.createDefault();
    }

    @Benchmark
    public Thread testCreateThread() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        thread.run();
        return thread;
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

    @Benchmark
    public String testRandomStringUtils() {
        return System.currentTimeMillis() + RandomStringUtils.randomNumeric(4);
    }

    @Benchmark
    public String testlocalDateTimeBenchMark() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
    }
}
