package src.剑指offer;

import org.junit.Test;
import src.剑指offer.base.TreeNode;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
 * ，则重建二叉树并返回。
 */
public class Solution_4 {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length != in.length) {
            return null;
        }

        return reConStruct(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }

    public TreeNode reConStruct(int[] pre, int[] in, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        int val = pre[preLeft];
        TreeNode root = new TreeNode(val);
        int count = 0;
        for (int i = inLeft; i <= inRight; i++) {
            if (in[i] == val) {
                root.left = reConStruct(pre, in, preLeft + 1, preLeft + count, inLeft, inLeft + count - 1);
                root.right = reConStruct(pre, in, preLeft + count + 1, preRight, inLeft + count + 1, inRight);
            }
            count++;
        }

        return root;
    }

    @Test
    public void test() {
        int[] pre = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] in = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        new Solution_4().reConstructBinaryTree(pre, in);
    }

}

