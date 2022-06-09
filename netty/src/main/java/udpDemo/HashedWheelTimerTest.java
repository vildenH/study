package udpDemo;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.Timer;
import io.netty.util.TimerTask;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class HashedWheelTimerTest {

    public static void main(String[] args) throws InterruptedException {
        Timer timer = new HashedWheelTimer();

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run(Timeout timeout) throws Exception {
                System.out.println("timeout1:" + new Date());
                timer.newTimeout(this, 1, TimeUnit.SECONDS);
            }
        };
        Timeout timeout1 = timer.newTimeout(timerTask,
                1, TimeUnit.SECONDS);
        timer.newTimeout(timeout -> {

            System.out.println("timeout2: " + new Date());

            Thread.sleep(5000);

        }, 1, TimeUnit.SECONDS);


        TimeUnit.SECONDS.sleep(10);
    }
}
