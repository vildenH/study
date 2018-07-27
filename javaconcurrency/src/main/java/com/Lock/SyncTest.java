package com.Lock;

/**
 * @author wh
 * @date 2018/7/23
 */
public class SyncTest {

    Object lock = new Object();

    public void sync() {

        synchronized (lock) {

            System.out.println("get lock");

        }
    }
}
