package com.TimeUnit;

import static java.util.concurrent.TimeUnit.MINUTES;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @author wh
 * @date 2018/7/18
 */
public class TimeUnitTest {
    public static void main(String[] args) throws InterruptedException {

        Thread.sleep(1000);
        System.out.println(SECONDS.convert(60, MINUTES));

    }
}
