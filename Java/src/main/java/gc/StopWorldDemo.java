package gc;

import java.util.HashMap;

/**
 * @author wh
 * @date 2018/10/21
 */
public class StopWorldDemo {

  public static class MyThread extends Thread {

    HashMap map = new HashMap();

    @Override
    public void run() {
      try {
        while (true) {
          if (map.size() * 512 / 1024 / 1024 >= 400) {
            map.clear();
            System.out.println("map is clear");
          }
          byte[] b1;
          for (int i = 0; i < 100; i++) {
            b1 = new byte[512];
            map.put(System.nanoTime(), b1);
          }
        }

      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public static class PrintThread extends Thread {

    private final long startTime = System.currentTimeMillis();

    @Override
    public void run() {
      try {
        while (true) {
          //每毫秒打印时间信息
          long t = System.currentTimeMillis() - startTime;
          System.out.println(t / 1000 + "," + t % 1000);
          Thread.sleep(1000);
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * -Xmx512M -Xms512M -XX:+UseSerialGC -Xloggc:gc.log -XX:+PrintGCDetails
   */
  public static void main(String[] args) {
    MyThread t = new MyThread();
    PrintThread p = new PrintThread();
    t.start();
    p.start();
  }
}
