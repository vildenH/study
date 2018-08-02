package src.Tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintFromTopToBottom {

    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList arrayList = new ArrayList();
        if (root == null) {
            return arrayList;
        }
        Queue queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode nowNode = (TreeNode) queue.poll();
            arrayList.add(nowNode.val);
            if (nowNode.left != null) {
                queue.add(nowNode.left);
            }
            if (nowNode.right != null) {
                queue.add(nowNode.right);
            }
        }
        return arrayList;


    }
}
