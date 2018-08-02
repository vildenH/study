package src.List;

//找到两链表的公共节点
public class FindFirstCommonNode {
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int length1 = 0;
        int length2 = 0;

        ListNode tempNode = pHead1;
        while (tempNode != null) {
            tempNode = tempNode.next;
            length1++;
        }
        tempNode = pHead2;
        while (tempNode != null) {
            tempNode = tempNode.next;
            length2++;
        }

        ListNode tempNode2 = null;
        int cha = Math.abs(length1 - length2);
        if (length1 > length2) {
            tempNode = pHead1;
            tempNode2 = pHead2;
            while (cha != 0) {
                tempNode = tempNode.next;
                cha--;
            }
        } else if (length1 < length2) {
            tempNode = pHead2;
            tempNode2 = pHead1;
            while (cha != 0) {
                tempNode = tempNode.next;
                cha--;
            }
        } else {
            tempNode = pHead1;
            tempNode2 = pHead2;
        }
        while (tempNode != tempNode2) {
            tempNode = tempNode.next;
            tempNode2 = tempNode2.next;
        }


        return tempNode;
    }
}
