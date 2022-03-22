package src;


import src.List.ListNode;
import src.Tree.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wh
 * @date 2019/3/6
 */
public class Main {

    //1 - 2 - 3
    //1
    //1 - 2 - 3 - 4

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode prevHead = new ListNode(1);
        prevHead.next = head;
        ListNode slow = prevHead;
        ListNode fast = prevHead;

        ListNode prev = prevHead;
        for (int i = 0; i < n; i++) {
            if (fast == null) {
                return head;
            }
            fast = fast.next;
        }
        while (fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        if (slow == head) {
            return slow.next;
        } else {
            prev.next = slow.next;
            return head;
        }
    }


}
