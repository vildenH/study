package com.Callable;

import org.apache.commons.lang3.RandomUtils;

import java.util.concurrent.*;

/**
 * @author wh
 * @date 2018/7/17
 */
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建线程池
        ExecutorService pool = Executors.newFixedThreadPool(2);
        //创建两个有返回值的任务
        Callable c1 = new MyCallable("A");
        Callable c2 = new MyCallable("B");

        //执行任务并获得Future对象
        //这里需要注意Future对象的get方法是阻塞的，如果先调用了get的话，Future对象会一直等到返回结果.
        Future f1 = pool.submit(c1);
        System.out.println(f1.get());
        Future f2 = pool.submit(c2);
        System.out.println(f2.get());
        pool.shutdown();

    }
}

class MyCallable implements Callable {
    private String CallableName;

    public MyCallable(String CallableName) {
        this.CallableName = CallableName;
    }

    @Override
    public Object call() throws Exception {
        int workSeconds = RandomUtils.nextInt(1, 5);
        System.out.println(CallableName + "需要执行" + workSeconds + "秒");
        Thread.sleep(1000 * workSeconds);
        System.out.println(CallableName + "任务完成了");
        return CallableName + "任务返回的内容";
    }
}