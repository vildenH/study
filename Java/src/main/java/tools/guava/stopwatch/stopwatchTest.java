package tools.guava.stopwatch;

import com.google.common.base.Stopwatch;
import java.util.concurrent.TimeUnit;

/**
 * @author wh
 * @date 2018/9/25
 */
public class stopwatchTest {

  public static void stopWatchTest() throws InterruptedException {
    Stopwatch started = Stopwatch.createStarted();
    TimeUnit.SECONDS.sleep(2);
    System.out.println(started.elapsed(TimeUnit.MILLISECONDS));
    TimeUnit.SECONDS.sleep(2);
    System.out.println(started.elapsed(TimeUnit.MILLISECONDS));


  }

  public static void stopWatchTest2() throws InterruptedException {
    Stopwatch started = Stopwatch.createStarted();
    TimeUnit.SECONDS.sleep(1);
    started.stop();
    System.out.println(started.elapsed(TimeUnit.MILLISECONDS));
    TimeUnit.SECONDS.sleep(1);
    System.out.println(started.elapsed(TimeUnit.MILLISECONDS));
  }

  public static void stopWatchTest3() throws InterruptedException {
    Stopwatch started = Stopwatch.createStarted();
    TimeUnit.SECONDS.sleep(1);
    System.out.println(started.elapsed(TimeUnit.MILLISECONDS));
    started.reset().start();
    TimeUnit.SECONDS.sleep(2);
    System.out.println(started.elapsed(TimeUnit.MILLISECONDS));
  }

  public static void main(String[] args) throws InterruptedException {
    stopWatchTest2();

    System.out.println("test 3 ------");
    stopWatchTest3();

  }
}
