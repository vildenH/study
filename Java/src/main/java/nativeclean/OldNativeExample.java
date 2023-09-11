package nativeclean;

import org.springframework.jdbc.support.incrementer.PostgresSequenceMaxValueIncrementer;

import java.util.concurrent.TimeUnit;

public class OldNativeExample {

    public static void main(String[] args) throws InterruptedException {

        NativeHandler nativeHandler = new NativeHandler(123);
        while (true) {
            nativeHandler = null;
            System.gc();
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
