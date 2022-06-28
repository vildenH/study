package tools;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.junit.Test;

import java.nio.charset.Charset;

public class BloomTest {

    BloomFilter<String> filter = BloomFilter.create(Funnels.stringFunnel(Charset.defaultCharset()), 1000, 0.005);

    @Test
    public void test() {
        filter.put("!23");
        System.out.println(filter.mightContain("!23"));
        System.out.println(filter.mightContain("234"));
    }
}
