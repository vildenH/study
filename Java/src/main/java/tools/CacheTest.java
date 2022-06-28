package tools;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import org.elasticsearch.threadpool.FixedExecutorBuilder;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static com.google.common.base.Preconditions.checkNotNull;

public class CacheTest {
    AtomicInteger loadTimes = new AtomicInteger(0);
    AtomicInteger count = new AtomicInteger(0);
    ExecutorService executor = Executors.newFixedThreadPool(5);

    @Test
    public void test() throws IOException {
        LoadingCache<String, SkuCache> loadingCache = CacheBuilder.newBuilder()
                .refreshAfterWrite(1000, TimeUnit.MILLISECONDS)
                .expireAfterWrite(3000, TimeUnit.MILLISECONDS)
                .build(new CacheLoader<String, SkuCache>() {
                    @Override
                    public SkuCache load(String key) {
                        SkuCache skuCache = new SkuCache();
                        skuCache.setSkuId(key);
                        skuCache.setRealQuantity(100L);
                        System.out.println("load--------" + key);
                        //if (loadTimes.get() > 20) {
                        //    skuCache.setSkuCode(key + "---after exception" + (loadTimes.incrementAndGet()));
                        //    return skuCache;
                        //}
                        if (loadTimes.get() > 10) {
                            loadTimes.incrementAndGet();
                            throw new RuntimeException("模拟触发DB挂掉的场景");
                        }
                        skuCache.setSkuCode(key + "---no exception" + (loadTimes.incrementAndGet()));
                        return skuCache;
                    }

                    //@Override
                    //public ListenableFuture<SkuCache> reload(String key, SkuCache oldValue) throws Exception {
                    //    checkNotNull(key);
                    //    checkNotNull(oldValue);
                    //    System.out.println("reload...");
                    //    try {
                    //        SkuCache load = load(key);
                    //        return Futures.immediateFuture(load);
                    //    } catch (Exception e) {
                    //        System.out.println("reload 触发了异常");
                    //    }
                    //    return Futures.immediateFuture(oldValue);
                    //}

                    @Override
                    public ListenableFuture<SkuCache> reload(String key, SkuCache oldValue) throws Exception {
                        checkNotNull(key);
                        checkNotNull(oldValue);
                        System.out.println("reload...");
                        ListenableFutureTask<SkuCache> skuCacheListenableFutureTask = ListenableFutureTask.create(() -> {
                            try {
                                return load(key);
                            } catch (Exception e) {
                                return oldValue;
                            }
                        });
                        executor.submit(skuCacheListenableFutureTask);
                        return skuCacheListenableFutureTask;
                    }
                });
        for (
                int i = 0;
                i < 1000; i++) {
            new Thread(() -> {
                try {
                    getValue(loadingCache);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
        System.in.read();
        System.out.println("finish");
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