package interview.Main;

/**
 * @author wh
 * @date 2018/11/14
 */
public class Test {
    private static Object obj = new Object();

    public static synchronized void SyncMethod() {
        //允许访问临界区控制的代码
        System.out.println("hello world");
    }

    public synchronized void SyncMethod2() {
        //允许访问临界区控制的代码
        System.out.println("hello world");
    }

    public void SyncMethod3() {
        synchronized (obj) {
            //允许访问临界区控制的代码
            System.out.println("hello world");
        }
    }


}
