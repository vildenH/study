import java.util.Calendar;
import java.util.Date;

/**
 * @author wh
 * @date 2018/7/13
 */
public class Test {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, 9, 1);
        Date date = calendar.getTime();
        Date nowDate = new Date();
        int day = (int) ((date.getTime() - nowDate.getTime()) / (1000 * 3600 * 24));
        System.out.println(day);
    }
}
