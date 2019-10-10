package com.thread;

/**
 * @author wh
 * @date 2019/10/8
 */
public class TheadErrorTest {

  public static int count = 0;

  public static void main(String[] args) throws InterruptedException {
    Thread thread = new Thread(() -> {
      synchronized (TheadErrorTest.class) {
        while (true) {
          while (count % 2 != 0) {
            try {
              TheadErrorTest.class.wait();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
          System.out.println("oushu : " + count);
          count++;
          TheadErrorTest.class.notify();
        }
      }
    });

    Thread thread2 = new Thread(() -> {
      synchronized (TheadErrorTest.class) {
        while (true) {
          while (count % 2 == 0) {
            try {
              TheadErrorTest.class.wait();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
          System.out.println("jishu : " + count);
          count++;
          TheadErrorTest.class.notify();
        }
      }
    });
    thread.start();
    thread2.start();
  }


}
