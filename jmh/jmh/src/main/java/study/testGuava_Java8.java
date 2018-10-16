package study;

import com.google.common.base.Joiner;
import org.openjdk.jmh.annotations.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author wh
 * @date 2018/9/27
 */
@OutputTimeUnit(TimeUnit.NANOSECONDS)
// 测试方法平均执行时间
@BenchmarkMode(Mode.AverageTime)
// 测试方法进程数
@Fork(1)
public class testGuava_Java8 {

    @Benchmark
    public String joinerJava8() {
        List<String> strList = Arrays.asList("one", "two", "three", null);
        String csv = strList.stream().filter(Objects::nonNull).collect(Collectors.joining(","));
        return csv;
    }

    @Benchmark
    public String joinerGuava() {
        List<String> strList = Arrays.asList("one", "two", "three", null);
        String csv = Joiner.on(",").skipNulls().join(strList);
        return csv;
    }

}
