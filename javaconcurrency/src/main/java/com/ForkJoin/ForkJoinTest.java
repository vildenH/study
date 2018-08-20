package com.ForkJoin;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author wh
 * @date 2018/7/26
 */

//对一个大数组进行并行求和的Task
public class ForkJoinTest extends RecursiveTask<Long> {
    public static final int ARRAY_LENGTH = 20000 * 17000;
    long[] data;
    int start;
    int end;

    public ForkJoinTest(long[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long sum = 0;
        if ((end - start) < 1000) {
            for (int i = start; i <= end; i++) {
                sum += data[i];
            }
        } else {
            int middle = (start + end) >> 1;
            ForkJoinTest left = new ForkJoinTest(data, start, middle);
            ForkJoinTest right = new ForkJoinTest(data, middle + 1, end);
            invokeAll(left, right);
            sum = left.join() + right.join();
        }
        return sum;
    }

    public static void main(String[] args) {
        long[] data = new long[ARRAY_LENGTH];
        Arrays.setAll(data, i -> i);
        StopWatch stopWatch = new StopWatch();
        System.out.println("Fork Join 任务开始了");
        stopWatch.start();
        long sum = new ForkJoinPool().invoke(
                new ForkJoinTest(data, 0, data.length - 1)
        );
        stopWatch.stop();
        System.out.println(sum);
        System.out.println("Fork Join 耗时:" + stopWatch.getTime());
        sum = 0;
        stopWatch.reset();
        stopWatch.start();
        System.out.println("普通任务开始了");
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            sum = sum + data[i];
        }
        System.out.println(sum);
        stopWatch.stop();
        System.out.println("普通任务耗时:" + stopWatch.getTime());

    }
}
