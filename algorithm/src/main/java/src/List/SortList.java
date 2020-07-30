package src.List;

public class SortList {

  public ListNode sortList(ListNode head) {
    int listLength = 0;
    for (ListNode temp = head; temp != null; temp = temp.next) {
      listLength++;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    for (int i = 1; i < listLength; i = 2 * i) {
      ListNode cur = dummy.next;
      ListNode tail = dummy;
      while (cur != null) {
        ListNode left = cur;
        ListNode right = cut(cur, i);
        cur = cut(right, i);
        tail.next = merge(left, right);
        while (tail.next != null) {
          tail = tail.next;
        }
      }
    }
    return dummy.next;
  }

  public static ListNode cut(ListNode head, int n) {
    if (n <= 0) {
      return head;
    }
    ListNode p = head;
    while (p != null && n > 0) {
      p = p.next;
      n--;
    }
    if (p == null) {
      return null;
    }
    ListNode next = p.next;
    p.next = null;
    return next;
  }

  public static ListNode merge(ListNode list1, ListNode list2) {
    ListNode dummyHead = new ListNode(Integer.MIN_VALUE), p = dummyHead;
    while (list1 != null && list2 != null) {
      if (list1.val < list2.val) {
        p.next = list1;
        list1 = list1.next;
      } else {
        p.next = list2;
        list2 = list2.next;
      }
      p = p.next;
    }
    if (list1 == null) {
      p.next = list2;
    } else {
      p.next = list1;
    }
    return dummyHead.next;
  }

  public static void main(String[] args) {
    ListNode _4 = new ListNode(4);
    ListNode _2 = new ListNode(2);
    ListNode _1 = new ListNode(1);
    ListNode _3 = new ListNode(3);

    _4.next = _2;
    _2.next = _1;
    _1.next = _3;

    ListNode listNode = new SortList().sortList(_4);

    while (listNode != null) {
      System.out.print(listNode.val + "-->");
      listNode = listNode.next;
    }
    System.out.println("null");
  }
}
