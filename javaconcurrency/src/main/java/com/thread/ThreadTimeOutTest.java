package com.thread;

import java.util.concurrent.*;

/**
 * @author wh
 * @date 2018/9/26
 * <p>
 * <p>
 * 该测试在futureGet停止时是否会让子线程中断
 * 1.如果线程处于阻塞的情况，那么线程需要catch到interrupt异常，那么在catch中处理异常来响应中断
 * 2.正常运行情况，线程不会中断。
 * 3.可以使用Thread.currentThread().isInterrupted())来响应中断。
 */
public class ThreadTimeOutTest {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(40);//创建一个可容纳40个线程的线程池
        for (int i = 0; i < 2; i++) {
            System.out.println(i + "开始时间：" + System.currentTimeMillis());
            Future future = pool.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {

                            System.out.println(Thread.currentThread() + "rua");

                            // if (Thread.currentThread().isInterrupted()) {
                            //     System.out.println("i has interputed");
                            //     break;
                            // }
                        }
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
            try {
                future.get(50, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                future.cancel(true);
            } catch (ExecutionException e) {
                future.cancel(true);
            } catch (TimeoutException e) {
                future.cancel(true);
            }
        }
        pool.shutdownNow();

    }
}
