package com.Lock;

import org.apache.commons.lang3.RandomUtils;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wh
 * @date 2018/7/18
 */
public class LockTest {
    private Lock lock = new ReentrantLock();

    private void needSyncMethod(Thread thread) {
        lock.lock();
        try {
            System.out.println("线程名:" + thread.getName() + "获得了锁");
            TimeUnit.SECONDS.sleep(RandomUtils.nextInt(1, 3));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("线程名:" + thread.getName() + "释放了锁");
            lock.unlock();
        }

    }

    public static void main(String[] args) {
        final LockTest lockTest = new LockTest();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lockTest.needSyncMethod(Thread.currentThread());
            }
        }, "t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                lockTest.needSyncMethod(Thread.currentThread());
            }
        }, "t2");
    }
}
