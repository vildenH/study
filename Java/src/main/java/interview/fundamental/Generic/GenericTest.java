package interview.fundamental.Generic;

/**
 * @author wh
 * @date 2018/8/31
 */
public class GenericTest {
    public static <T extends Number> void test(Class<T> tClass) {
        System.out.println(tClass.toGenericString());
        System.out.println(tClass.toString());
    }

    // public static void main(String[] args) {
    //
    //     test(Long.class);
    //
    // }

}
