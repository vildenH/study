package com.FutureTask;

import java.util.concurrent.*;

/**
 * @author wh
 * @date 2018/7/17
 */
public class FutureTaskTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newCachedThreadPool();
        Task task = new Task();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
        executor.submit(futureTask);
        executor.shutdown();
        Thread.sleep(1000);
        System.out.println("主线程执行任务!");
        System.out.println("task运行结果" + futureTask.get());
        System.out.println("所有任务结束");
    }
}


class Task implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("子线程开始运算");
        Thread.sleep(3000);
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum = sum + i;
        }
        return sum;
    }
}