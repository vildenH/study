package gc;

import java.io.IOException;

/**
 * @author wh
 * @date 2018/10/20
 */
public class JVMDemoTest {

  private static int count;

  private void recur() {
    count++;
    System.out.println(count);
    recur();
  }

  private void testStack() {
    try {
      new JVMDemoTest().testStack();
    } catch (Exception e) {
      System.out.println(e);
    }
    while (true) {
      recur();
    }
  }

  public static void main(String[] args) throws IOException {

    for (int i = 0; i < Integer.MAX_VALUE; i++) {
      String str = String.valueOf(i).intern();
      System.out.println(str);
    }

  }
}
