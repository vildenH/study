package src.List;

//删除链表中有重复的节点
public class DeleteDuplication {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode fakeHead = new ListNode(-1);
        ListNode nowNode = pHead;
        ListNode preNode = fakeHead;
        fakeHead.next = pHead;
        while (nowNode != null && nowNode.next != null) {
            if (nowNode.val == nowNode.next.val) {
                int val = nowNode.val;
                while (nowNode != null && nowNode.val == val) {
                    nowNode = nowNode.next;
                }
                preNode.next = nowNode;
            } else {
                preNode = nowNode;
                nowNode = nowNode.next;
            }
        }
        return fakeHead.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        ListNode result = new DeleteDuplication().deleteDuplication(n1);
        while (result != null) {
            System.out.print(result.val + "-->");
            result = result.next;
        }
        System.out.println("null");

    }
}
