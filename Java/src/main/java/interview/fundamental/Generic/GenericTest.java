package interview.fundamental.Generic;

/**
 * @author wh
 * @date 2018/8/31
 */
public class GenericTest {
    public static <T extends String> T test(Class<T> tClass) throws IllegalAccessException, InstantiationException {
        System.out.println(tClass.toGenericString());
        System.out.println(tClass.toString());
        return tClass.newInstance();
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {

        test(String.class);

    }

}
