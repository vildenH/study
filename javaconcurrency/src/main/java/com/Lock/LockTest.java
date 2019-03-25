package com.Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

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
    t1.start();
    t2.start();
  }

  private static int count = 0;
  private static Object lockA = new Object();
  private static boolean isOushu = true;

  //交替打印奇偶数
  @Test
  public void test() throws InterruptedException {

    new Thread(() ->
    {

      while (count < 100) {
        synchronized (lockA) {
          if (isOushu) {
            System.out.println("oushu:" + count);
            count++;
            isOushu = false;
          }
        }
      }
    }
    ).start();

    new Thread(() -> {
      while (count < 100) {
        synchronized (lockA) {
          if (!isOushu) {
            System.out.println("jishu:" + count);
            count++;
            isOushu = true;

          }
        }
      }
    }
    ).start();

    TimeUnit.SECONDS.sleep(100);
  }

  @Test
  public void test2() throws InterruptedException {
    new Thread(() -> {
      while (count < 100) {
        synchronized (lockA) {
          while (!isOushu) {
            try {
              lockA.wait();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
          System.out.println("oushu:" + count);
          count++;
          isOushu = false;
          lockA.notify();
        }
      }
    }
    ).start();

    new Thread(() -> {
      while (count < 100) {
        synchronized (lockA) {
          while (isOushu) {
            try {
              lockA.wait();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
          System.out.println("jishu:" + count);
          count++;
          isOushu = true;
          lockA.notify();
        }
      }

    }
    ).start();

    TimeUnit.SECONDS.sleep(1);
  }
}
