package src.Tree;

/**
 * @author wh
 * @date 2019/11/12
 */
public class SegmentTree {

  Node root;

  public void build(int left, int right) {
    root = new Node(left, right);
    build(root);
  }

  public void build(Node root) {
    int left = root.left;
    int right = root.right;
    //root 节点为叶子节点
    if (right - left == 1) {
      return;
    } else if (right - left > 1) {
      int mid = (left + right) >> 1;
      Node leftNode = new Node(left, mid);
      Node rightNode = new Node(mid, right);
      root.leftChild = leftNode;
      root.rightChild = rightNode;
      //递归建树
      build(leftNode);
      build(rightNode);
    }
  }

  //插入线段
  public void insert(int c, int d) {
    insert(c, d, root);
  }

  public void insert(int c, int d, Node node) {
    if (node == null || c < node.left || d > node.right) {
      throw new IllegalArgumentException("参数不合法,插入线段长度不对,c:" + c + ",d:" + d);
    }
    if (node.left == c && node.right == d) {
      node.count++;
      node.cover = true;
      return;
    }
    int mid = (node.left + node.right) >> 1;
    if (d <= mid) {
      insert(c, d, node.leftChild);
    } else if (c >= mid) {
      insert(c, d, node.rightChild);
    } else {
      insert(c, mid, node.leftChild);
      insert(mid, d, node.rightChild);
    }

  }

  private static class Node {

    int left, right;//左右区间的值
    boolean cover;//表示是否被覆盖
    int count;//表示此节点表示的线段区间出现的次数（被覆盖的次数），默认为0
    Node leftChild;
    Node rightChild;

    Node(int left, int right) {
      this.left = left;
      this.right = right;
      cover = false;
      count = 0;
    }
  }
}
