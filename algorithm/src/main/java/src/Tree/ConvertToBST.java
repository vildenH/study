package src.Tree;


import src.List.ListNode;

public class ConvertToBST {
    public TreeNode convert(int[] nums, int left, int right) {

        if (left > right) {
            return null;
        }
        int mid = (left + right) >> 1;
        TreeNode newNode = new TreeNode(nums[mid]);
        newNode.left = convert(nums, left, mid - 1);
        newNode.right = convert(nums, mid + 1, right);
        return newNode;

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) {
            return null;
        }
        return convert(nums, 0, nums.length - 1);
    }


    public TreeNode sortedListToBST(ListNode head, ListNode tail) {
        ListNode slow = head;
        ListNode fast = head;
        return null;
    }

    public TreeNode sortedListToBST(ListNode head) {
        return null;
    }
}
