package interview.Main;

import org.apache.commons.lang3.RandomUtils;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
public class main {
    public static void main(String[] args) throws InterruptedException {
    }

    public static void testPoolExecutor() {
        BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<Runnable>();
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 5, 60, TimeUnit.SECONDS, workQueue);
        for (int i = 0; i < 10; i++) {
            Thread a = new Thread(new Runnable() {
                @Override
                public void run() {

                    System.out.println("xxxxxxxx");
                }
            });
            a.setName("111");
            System.out.println("xxx" + a.getId() + a.getName());
            poolExecutor.execute(a);
        }
        ;
    }

    public static void mtkl2Pi(){

        long count = 0;
        for (long time = 10000L; time < 100000000000L; time = time * 10) {
            System.out.println("time = " + time);
            for (int i = 0; i < time; i++) {
                double x = RandomUtils.nextDouble(0, 2) - 1;
                double y = RandomUtils.nextDouble(0, 2) - 1;
                if (((x * x) + (y * y)) <= 1) {
                    count++;
                }

            }
            System.out.println(count * 4 / (time * 1.0));
            count = 0;
        }
    }
}
