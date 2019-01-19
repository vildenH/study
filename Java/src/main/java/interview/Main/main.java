package interview.Main;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class main {
    public static void main(String[] args)
    {
        BlockingQueue<Runnable> workQueue=new LinkedBlockingDeque<Runnable>();
        ThreadPoolExecutor poolExecutor=new ThreadPoolExecutor(5, 5, 60, TimeUnit.SECONDS, workQueue);
        for(int i =0 ;i< 10;i++){
            Thread a = new Thread(new Runnable() {
                @Override
                public void run() {

                    System.out.println("xxxxxxxx");
                }
            });
            a.setName("111");
            System.out.println("xxx"+a.getId() + a.getName());
            poolExecutor.execute(a);
        }
    }
}
