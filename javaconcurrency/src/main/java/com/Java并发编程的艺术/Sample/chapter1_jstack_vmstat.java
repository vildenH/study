package com.Java并发编程的艺术.Sample;

import java.util.concurrent.TimeUnit;

/**
 * @author wh
 * @date 2018/9/17
 */
public class chapter1_jstack_vmstat {
    public static void main(String[] args) {

        for (int i = 0; i < 50; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        TimeUnit.SECONDS.sleep(120);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
