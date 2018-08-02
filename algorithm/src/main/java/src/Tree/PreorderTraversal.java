package src.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {
    List<Integer> ans;

    public List<Integer> preorderTraversal(TreeNode root) {
        ans = new LinkedList<Integer>();
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        TreeNode curNode;
        while (stack.isEmpty() != true) {
            curNode = stack.pop();
            ans.add(curNode.val);
            if (curNode.right != null) {
                stack.push(curNode.right);
            }
            if (curNode.left != null) {
                stack.push(curNode.left);
            }

        }
        return ans;
    }
}
