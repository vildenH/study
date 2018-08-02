package com.practice;

/**
 * @author wh
 * @date 2018/7/23
 */


import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * 三线程轮流打印ABC
 * 个人总结有两种情形，乐观情形，：
 * 1.三线程轮流工作，同步协作。
 * 2.三线程乐观争用锁判断条件是否符合。
 */
public class abcTest {

    public static void main(String[] args) {

        List<Double> cost = Arrays.asList(10.0, 20.0, 30.0);
        cost.stream().map(new Function<Double, Double>() {
            @Override
            public Double apply(Double num) {
                return num * 2;
            }
        }).forEach(x -> System.out.println(x));
    }
}

