package src.Tree;

public class TreeDepth {
    public int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = treeDepth(root.left) + 1;
        int rightDepth = treeDepth(root.right) + 1;
        return leftDepth > rightDepth ? leftDepth : rightDepth;


    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftDepth = treeDepth(root.left);
        int rightDepth = treeDepth(root.right);
        int diff = leftDepth - rightDepth;
        if (diff > 1 || diff < -1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
}
