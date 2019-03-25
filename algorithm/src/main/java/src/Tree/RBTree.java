package src.Tree;

/**
 * @author wh
 * @date 2019/2/28
 */
public class RBTree {

  public static void main(String[] args) {
    long start = System.currentTimeMillis();
    for (int i = 0; i < 1024; i++) {
      fuck();
    }
    long end = System.currentTimeMillis();
    System.out.println("总共时间:" + (end - start));
  }

  public static void fuck() {
    System.out.println("1");
  }
}
