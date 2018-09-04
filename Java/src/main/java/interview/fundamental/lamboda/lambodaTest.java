package interview.fundamental.lamboda;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wh
 * @date 2018/8/30
 */
public class lambodaTest {

    @Test
    public void listTest() {
        List<String> collected = Stream.of("a", "b", "c")
                .collect(Collectors.toList());
        Assert.assertEquals((Arrays.asList("a", "b", "c")), collected);
    }
}
