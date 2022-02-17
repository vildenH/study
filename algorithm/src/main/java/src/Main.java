package src;


import src.Tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wh
 * @date 2019/3/6
 */
public class Main {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int[] ans = new int[k];
        dfs(result, ans, 1, 0, n, k);
        return result;
    }

    // n是当前层数
    public void dfs(List<List<Integer>> result, int[] ans, int startInt, int nowIndex, int n, int k) {
        if (nowIndex == k) {
            result.add(Arrays.stream(ans)
                    .boxed()
                    .collect(Collectors.toList()));
            return;
        }
        for (int i = startInt; i <= n; i++) {
            ans[nowIndex] = i;
            dfs(result, ans, i + 1, nowIndex + 1, n, k);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> combine = new Main().combine(5, 2);
    }
}
