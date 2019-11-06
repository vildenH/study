package src.dfs;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wh
 * @date 2019/11/6
 * leetcode-22
 */
public class generateParenthese {

  public static void main(String[] args) {
    new generateParenthese().generateParenthesis(3);
  }

  public List<String> generateParenthesis(int n) {
    List result = new LinkedList<>();
    dfs(result, "", 0, 0, n);
    return result;
  }

  public void dfs(List result, String str, int left, int right, int max) {
    if ((left + right) == max * 2) {
      result.add(str);
      return;
    }
    if (left < max) {
      dfs(result, str + "(", left + 1, right, max);
    }
    if (left > right) {
      dfs(result, str + ")", left, right + 1, max);
    }
  }
}
