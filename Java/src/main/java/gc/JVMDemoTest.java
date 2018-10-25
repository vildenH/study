package gc;

import java.io.IOException;

/**
 * @author wh
 * @date 2018/10/20
 */
public class JVMDemoTest {
    public static void main(String[] args) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.exec("pwd"));
    }
}
