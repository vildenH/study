import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

/**
 * @author wh
 * @date 2018/7/13
 */
public class Test {
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 24; i++) {
            LocalTime beiJingTime = LocalTime.of(i, 0);
            LocalTime newYorkTime = beiJingTime.minusHours(13);
            System.out.printf("北京时间:%s  纽约时间:%s\n", beiJingTime, newYorkTime);
        }
    }

    /**
     * 生成微信网关错误码
     */
    public static void generateErrorCode() throws IOException {
        ClassLoader classLoader = Test.class.getClassLoader();
        File file = new File(classLoader.getResource("errorCode.data").getFile());
        List<String> list = IOUtils.readLines(new FileInputStream(file));
        // for (String line : list) {
        //     System.out.println(line);
        // }
        for (String line : list) {
            if (StringUtils.isNotBlank(line)) {
                String[] split = line.split(" ");
                System.out.printf(" %s(\"%s\", \"%s\", \"%s\", \"%s\"),\n", split[0], split[0], split[1], split[2], split[3]);
            }
        }
    }
}
