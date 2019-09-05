package wh.learn;

import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;

import java.util.Arrays;

/**
 * @author wh
 * @date 2019/9/4
 */
public class MyFirstFlink {
    public static void main(String[] args) throws Exception {
        // We will write our code here
        final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        DataSet<String> letters = env.fromCollection(Arrays.asList("a", "b", "c"));
        System.out.println();

        // Start Flink application
        env.execute();
    }
}
