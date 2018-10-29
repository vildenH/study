package interview.Main;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class main {
    public static Map<String, String> map;

    public static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public static void main(String[] args) throws InterruptedException {

        map = new HashMap<>();
        map.put("test", "test");
        new Thread(new Runnable() {


            @Override
            public void run() {
                synchronized (map) {
                    try {
                        TimeUnit.SECONDS.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }).start();
        TimeUnit.SECONDS.sleep(1);

        while (true) {
            System.out.println(map.get("test"));
            TimeUnit.MILLISECONDS.sleep(50);
        }

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
}
