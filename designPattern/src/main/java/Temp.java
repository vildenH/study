import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

/**
 * @author wh
 * @date 2018/7/13
 */
public class Temp {

    public static void main(String[] args) throws IOException {

    }

    /**
     * 纽约时间和北京时间对比
     */
    @Test
    public void generateNewYorkTime() {
        for (int i = 0; i < 24; i++) {
            LocalTime beiJingTime = LocalTime.of(i, 0);
            LocalTime newYorkTime = beiJingTime.minusHours(13);
            System.out.printf("北京时间:%s  纽约时间:%s\n", beiJingTime, newYorkTime);
        }
    }

    /**
     * 生成微信网关错误码
     */
    @Test
    public void generateErrorCode() throws IOException {
        ClassLoader classLoader = Temp.class.getClassLoader();
        File file = new File(classLoader.getResource("errorCode.data").getFile());
        List<String> list = IOUtils.readLines(new FileInputStream(file));
        // for (String line : list) {
        //     System.out.println(line);
        // }
        for (String line : list) {
            if (StringUtils.isNotBlank(line)) {
                String[] split = line.split(" ");
                System.out.printf(" %s(\"%s\", \"%s\", \"%s\", \"%s\"),\n", split[0], split[0], split[1],
                        split[2], split[3]);
            }
        }
    }


    @Test
    public void formatCebCode() throws IOException {
        ClassLoader classLoader = Temp.class.getClassLoader();
        File file = new File(classLoader.getResource("cebfile.data").getFile());
        FileInputStream input = new FileInputStream(file);
        System.out.println();
        String s = IOUtils.toString(input);
        String[] split = s.split("\n");
        System.out.println("split length" + split.length);
        for (int i = 0; i < (split.length / 6); i++) {
            for (int j = i * 6; j < i * 6 + 6; j++) {
                System.out.print(split[j] + " ");
            }
            System.out.println("\n");
        }
    }

    @Test
    public void generateCebCode() throws IOException {
        ClassLoader classLoader = Temp.class.getClassLoader();
        File file = new File(classLoader.getResource("cebfile.data").getFile());
        List<String> list = IOUtils.readLines(new FileInputStream(file));
        for (String line : list) {
            if (StringUtils.isNotBlank(line)) {
                String[] split = line.split(" ");
                System.out.printf(" %s(\"%s\", \"%s\", \"%s\", \"%s\",\"%s\")),\n", split[0], split[1], split[2],
                        split[3], split[4], split[5]);
            }
        }
    }
}
