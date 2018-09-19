package gc;

/**
 * @author wh
 * @date 2018/9/19
 */
public class GCLogDemo {
    public static void main(String[] args) {
        int _1m = 4096 * 1024;
        byte[] data = new byte[_1m];
        // 将data置为null即让它成为垃圾
        data = null;
        // 通知垃圾回收器回收垃圾
         System.gc();
    }
}
