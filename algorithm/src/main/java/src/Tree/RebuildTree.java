package src.Tree;

public class RebuildTree {
    public TreeNode reBuild(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        int count = 0;
        for (int i = inStart; i < inEnd; i++) {
            if (in[i] == root.val) {
                root.left = reBuild(pre, in, preStart + 1, preStart + count, inStart, i - 1);
                root.right = reBuild(pre, in, preStart + count + 1, preEnd, i + 1, inEnd);
            }
            count++;
        }

        return root;
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length != in.length) {
            return null;
        }
        return reBuild(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }
}



