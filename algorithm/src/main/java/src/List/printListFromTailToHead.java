package src.List;

import java.util.ArrayList;

public class printListFromTailToHead {
    public void getAns(ListNode listNode, ArrayList<Integer> ans) {
        if (listNode == null) {
            return;
        }
        getAns(listNode.next, ans);
        ans.add(listNode.val);
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList<Integer> ans = new ArrayList<>();
        if (listNode == null) {
            return ans;
        } else {
            getAns(listNode, ans);
        }
        return ans;
    }
}
