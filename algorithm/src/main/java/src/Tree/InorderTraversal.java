package src.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//中序遍历
public class InorderTraversal {
    List<Integer> ans = new LinkedList<Integer>();

    public List<Integer> inorderTraversal(TreeNode root) {

        Stack<TreeNode> st = new Stack<TreeNode>();
        if (root == null) {
            return ans;
        }
        TreeNode temp = root;
        while (!st.empty() || temp != null) {
            while (temp != null) {
                st.push(temp);
                temp = temp.left;
            }
            if (st.empty() != true) {
                temp = st.pop();
                ans.add(temp.val);
                temp = temp.right;
            }


        }
        return ans;
    }
}
