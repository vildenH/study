package src.剑指offer;


import src.剑指offer.base.ListNode;

import java.util.ArrayList;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class Solution_3 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList();
        if (listNode == null) {
            return result;
        }
        return recursion(listNode, result);
    }

    public ArrayList recursion(ListNode listNode, ArrayList result) {
        if (listNode.next != null) {
            recursion(listNode.next, result);
        }
        result.add(listNode.val);
        return result;
    }
}
