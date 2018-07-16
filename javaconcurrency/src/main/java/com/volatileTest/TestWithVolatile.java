package com.volatileTest;

/**
 * @author wh
 * @date 2018/7/16
 */
public class TestWithVolatile {
    private static volatile boolean bChanged;

    public static void main(String[] args) throws InterruptedException {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    if (bChanged == !bChanged) {
                        System.out.println("!=");
                        System.exit(0);
                    }
                }
            }
        }.start();

        Thread.sleep(1000);
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    bChanged = !bChanged;
                }
            }
        }.start();
    }
}
