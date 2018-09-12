package tools.Date.Joda;

import org.joda.time.DateTime;

/**
 * @author wh
 * @date 2018/9/12
 */
public class Test {

    public static void main(String[] args) {
        DateTime dateTime = new DateTime(2000, 1, 1, 0, 0, 0, 0);
        System.out.println(dateTime);
        //获取现在的时间
        dateTime = new DateTime();
        System.out.println(dateTime);
        //获取世纪
        System.out.println(dateTime.getCenturyOfEra());
        //获取时区
        System.out.println(dateTime.getZone());

        testWithFun();

    }

    public static void testWithFun() {
        DateTime dt = new DateTime();
        DateTime year2000 = dt.withYear(2000);
        DateTime twoHoursLater = dt.plusHours(2);
        System.out.println(year2000);
        System.out.println(twoHoursLater);
    }
}
