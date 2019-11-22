package src.List;

import java.util.Random;

/**
 * @author wh
 * @date 2019/11/21
 */
public class SkipList {

  public SkipListNode head;
  public SkipListNode tail;

  //跳表容量
  public int count;
  //跳表高度
  public int height;

  public Random r;

  public SkipList create() {
    SkipList skipList = new SkipList();
    //创建首尾对象
    SkipListNode firstNode = SkipListNode.createFirstNode();
    SkipListNode lastNode = SkipListNode.createLastNode();
    //跳表初始化
    skipList.head = firstNode;
    skipList.tail = lastNode;
    //首尾对象连接
    firstNode.right = lastNode;
    lastNode.left = firstNode;
    return skipList;
  }

  public void insert() {

  }

  //如果传入的key值在跳跃表中存在，则findEntry返回该对象的底层节点；
  //如果传入的key值在跳跃表中不存在，则findEntry返回跳跃表中key值小于key，并且key值相差最小的底层节点；
  public SkipListNode search(int value) {
    SkipListNode nowNode;
    nowNode = head;
    while (true) {
      //从左往右找
      while (!nowNode.right.isLast && nowNode.right.value < value) {
        nowNode = nowNode.right;
      }
      if (nowNode.down != null) {
        nowNode = nowNode.down;
      } else {
        break;
      }
    }
    return nowNode;
  }

  public void update() {

  }

  public void delete() {

  }


  private static class SkipListNode {

    private boolean isFirst;
    private boolean isLast;


    public SkipListNode up;
    public SkipListNode down;
    public SkipListNode left;
    public SkipListNode right;

    public int value;

    public static SkipListNode createFirstNode() {
      SkipListNode skipListNode = new SkipListNode();
      skipListNode.isFirst = true;
      return skipListNode;
    }

    public static SkipListNode createLastNode() {
      SkipListNode skipListNode = new SkipListNode();
      skipListNode.isLast = true;
      return skipListNode;
    }

  }

}
