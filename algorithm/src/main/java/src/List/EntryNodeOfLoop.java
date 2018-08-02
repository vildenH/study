package src.List;

//找到有环链表的入口节点
public class EntryNodeOfLoop {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        if (pHead.next == pHead) {
            return pHead;
        }
        if (pHead.next == null) {
            return null;
        }
        ListNode fast = pHead;
        ListNode slow = pHead;
        while (fast != null) {

            fast = fast.next;
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next;
            } else {
                return null;
            }
            if (fast == slow) {
                fast = pHead;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}
