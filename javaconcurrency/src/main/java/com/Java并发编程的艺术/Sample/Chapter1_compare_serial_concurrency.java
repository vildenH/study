package com.Java并发编程的艺术.Sample;

/**
 * 多线程不一定快！如果创建大量空闲线程，name会造成比较大的线程上下文切换的开销。
 *
 */
public class Chapter1_compare_serial_concurrency {
    private static long count = 10000L;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("本实验测试不同测试数据下串行并行所需时间不同：");
        for (int i = 0; i < 6; i++) {
            System.out.println("第 " + i + " 次： count数目为： " + count);
            serial();
            concurrency();
            System.out.println("------------------------------------");
            count = count*10;
        }
    }

    private static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (long i = 0; i < count; i++) {
                    a ++;
                }
            }
        });
        thread.start();
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        thread.join();
        System.out.println("concurrency :" + time + "ms,b=" + b);
    }

    private static void serial() {
        long start = System.currentTimeMillis();
        int a = 0;
        for (long i = 0; i < count; i++) {
            a ++;
        }
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("serial:" + time + "ms,b=" + b + ",a=" + a);
    }


}
