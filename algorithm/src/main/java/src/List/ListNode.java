package src.List;

import java.util.List;

public class ListNode {

  int val;
  public ListNode next = null;

  public ListNode(int val) {
    this.val = val;
  }


  public static ListNode buildList(int[] i) {
    ListNode dummy = new ListNode(0);
    dummy.next = null;
    ListNode cur = dummy;
    for (int i1 : i) {
      ListNode listNode = new ListNode(i1);
      cur.next = listNode;
      cur = cur.next;
    }
    return dummy.next;
  }

  public static void printList(ListNode listNode) {
    while (listNode != null) {
      System.out.print(listNode.val + "-->");
      listNode = listNode.next;
    }
    System.out.println("null");
  }
}
