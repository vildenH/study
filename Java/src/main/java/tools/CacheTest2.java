package tools;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.UncheckedExecutionException;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static com.google.common.base.Preconditions.checkNotNull;

public class CacheTest2 {
    AtomicInteger loadTimes = new AtomicInteger(0);
    AtomicInteger count = new AtomicInteger(0);
    ExecutorService executor = Executors.newFixedThreadPool(5);

    @Test
    public void test() throws IOException {
        LoadingCache<String, SkuCache> loadingCache = CacheBuilder.newBuilder()
                .refreshAfterWrite(2000, TimeUnit.MILLISECONDS)
                .build(new CacheLoader<String, SkuCache>() {
                    @Override
                    public SkuCache load(String key) {
                        throw new NullPointerException();
                    }

                });


        try {
            loadingCache.getUnchecked("test");
        } catch (UncheckedExecutionException e) {
            if (e.getCause() instanceof NullPointerException) {
                System.out.println("密钥不存在");
            }
        }

    }

    private void getValue(LoadingCache<String, SkuCache> loadingCache) throws Exception {
        for (int i = 0; i < 1000; i++) {
            Thread.sleep(1000l);
            System.out.println(loadingCache.get("sku").toString() + " - " + count.incrementAndGet());
        }
    }

    class SkuCache {
        private String skuId;
        private String skuCode;
        private Long realQuantity;

        public String getSkuId() {
            return skuId;
        }

        public void setSkuId(String skuId) {
            this.skuId = skuId;
        }

        public String getSkuCode() {
            return skuCode;
        }

        public void setSkuCode(String skuCode) {
            this.skuCode = skuCode;
        }

        public Long getRealQuantity() {
            return realQuantity;
        }

        public void setRealQuantity(Long realQuantity) {
            this.realQuantity = realQuantity;
        }

        @Override
        public String toString() {
            return "SkuCache{" + "skuId='" + skuId + '\'' + ", skuCode='" + skuCode + '\'' + ", realQuantity=" + realQuantity + '}';
        }
    }
}