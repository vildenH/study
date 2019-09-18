package src.Tree;

/**
 * 红黑树基本规则：
 * 1. 每个结点要么是红的要么是黑的
 * 2. 根结点是黑的。
 * 3. 每个叶结点（叶结点即指树尾端NIL指针或NULL结点）都是黑的。 如果一个结点是红的，那么它的两个儿子都是黑的。
 * 4. 对于任意结点而言，其到叶结点树尾端NIL指针的每条路径都包含相同数目的黑结点。
 * 为了保证这个性质，则红黑树的高度可以保证在logn
 */

class RbTreeNode {


  RbTreeNode left;
  RbTreeNode right;
  int value;
  //true为红，false为黑
  boolean isRed;
}


public class RBTree {

  //
  public static RbTreeNode insert(RbTreeNode root, RbTreeNode insertNode) {
    if (root == null || insertNode == null) {
      return root;
    }
    return null;
  }

  public static RbTreeNode select(RbTreeNode rbTreeNode) {
    return null;
  }


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
