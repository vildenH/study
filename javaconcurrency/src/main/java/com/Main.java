package com;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {


    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        Thread thread1 = new Thread(() -> {
            try {
                lock.lock();
                System.out.println("thread 1 do something first");
                System.out.println("wait thread2 do something");
                condition.await();
                System.out.println("thread1 after wait");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();

            }

        });

        Thread thread2 = new Thread(() ->
        {
            try {
                lock.lock();
                System.out.println("thread 2 do something first");
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                condition.signal();
                System.out.println("thread 2 do something end");
            } finally {

                lock.unlock();
            }


        });

        thread1.start();
        thread2.start();


        TimeUnit.SECONDS.sleep(50);
    }
}
