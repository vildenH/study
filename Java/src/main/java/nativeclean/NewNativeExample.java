package nativeclean;

import java.util.concurrent.TimeUnit;

public class NewNativeExample {

    public static void main(String[] args) throws InterruptedException {

        CleaningExample cleaningExample = new CleaningExample();

        while (true) {
            cleaningExample = null;
            System.gc();
            TimeUnit.SECONDS.sleep(1);
        }

    }
}
