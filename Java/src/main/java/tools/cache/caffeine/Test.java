package tools.cache.caffeine;

/**
 * @author wh
 * @date 2018/9/4
 */
public class Test {
    public static void main(String[] args) {
        // LoadingCache<String, String> graphs = Caffeine.newBuilder()
        //         .maximumSize(10_000)
        //         .expireAfterWrite(5, TimeUnit.MINUTES)
        //         .refreshAfterWrite(1, TimeUnit.MINUTES)
        //         .build(key -> createExpensiveGraph(key));
    }
}
