package gc;

import java.awt.*;

/**
 * @author wh
 * @date 2018/9/19
 */
public class GCLogDemo {

    public static int _1m = 1024 * 1024;

    /**
     * 各种参数设置
     * -XX:+PrintGC -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xms4g PrintHeapAtGC
     */
    public static void main(String[] args) throws AWTException {
        // gcTestFullGc();

        Robot robot = new Robot();
        robot.mouseMove(1, 0);
    }

    public static void gcTestFullGc() {

        Object[] datas = new Object[1000];
        int i = 0;
        while (true) {
            byte[] data = new byte[_1m];
            datas[i % 1000] = data;
            i++;
        }

    }

    public static void gcYoungFrom() {
        Object[] datas = new Object[100];
        int i = 0;
        while (true) {
            byte[] data = new byte[_1m];
            datas[i % 100] = data;
            i++;
        }
    }

    public static void gcNormal() {
        byte[] data = new byte[_1m];
        // 将data置为null即让它成为垃圾
        data = null;
        // 通知垃圾回收器回收垃圾
        while (true) {
            data = new byte[_1m];
        }

    }


}
