package wh.learn;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;

import java.util.Arrays;
import org.apache.flink.api.java.operators.MapOperator;

/**
 * @author wh
 * @date 2019/9/4
 */
public class MyFirstFlink {

  public static void main(final String[] args) throws Exception {
    // We will write our code here
    final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
    DataSet<String> letters = env.fromCollection(Arrays.asList("a", "b", "c"));
    //map demo
    MapOperator<String, Object> afterTrans = letters.map(new MapFunction<String, Object>() {
      @Override
      public Object map(String string) throws Exception {
        return string.toUpperCase();
      }
    });

    letters.print();

    afterTrans.print();
    // Start Flink application
//        env.execute();
  }
}
