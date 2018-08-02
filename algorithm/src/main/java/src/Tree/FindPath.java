package src.Tree;

import java.util.ArrayList;
import java.util.LinkedList;

//查看二叉树路径和是否为target
//返回路径
public class FindPath {
    private int nowSum = 0;
    LinkedList list;

    public void dfs(TreeNode root, int target, ArrayList<ArrayList<Integer>> ans) {
        if (root == null) {
            return;
        }
        nowSum = nowSum + root.val;
        list.add(root.val);
        if (root.left == null && root.right == null && nowSum == target) {
            ArrayList temp = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                temp.add(list.get(i));
            }
            ans.add(temp);
        }
        if (root.left != null) {
            dfs(root.left, target, ans);
        }
        if (root.right != null) {
            dfs(root.right, target, ans);
        }
        nowSum = nowSum - root.val;
        list.removeLast();

    }

    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        nowSum = 0;
        list = new LinkedList();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

        dfs(root, target, ans);
        return ans;


    }
}
