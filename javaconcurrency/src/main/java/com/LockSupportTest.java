package com;

import org.junit.Test;
import sun.misc.Unsafe;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {

    @Test
    public void test() throws InterruptedException {
        Thread thread = new Thread(() -> {
            int count = 0;
            while (true) {
                if (count == 10) {
                    LockSupport.park();
                }
                count++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(count);
            }
        });

        thread.start();
        TimeUnit.SECONDS.sleep(15);
        LockSupport.unpark(thread);
        TimeUnit.SECONDS.sleep(10);

    }
}
