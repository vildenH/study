package src.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import org.junit.Test;

/**
 * @author wh
 * @date 2019/11/12
 */
public class Permutations2 {

  int[] map;
  HashMap set = new HashMap<>();

  void dfs(List result, Stack s, int[] nums) {
    if (s.size() == nums.length) {
      List anAns = new ArrayList(s);
      String tmp = "";
      for (int i = 0; i < anAns.size(); i++) {
        tmp = tmp + String.valueOf(anAns.get(i)) + ",";
      }
      if (set.get(tmp) == null) {
        result.add(anAns);
        set.put(tmp, tmp);
      }
    }
    for (int i = 0; i < nums.length; i++) {
      if (map[i] == 0) {
        map[i] = 1;
        s.push(nums[i]);
        dfs(result, s, nums);
        s.pop();
        map[i] = 0;
      }
    }
  }

  public List<List<Integer>> permuteUnique(int[] nums) {
    List result = new LinkedList<>();
    set = new HashMap();
    if (nums == null) {
      return result;
    }
    map = new int[nums.length];
    Arrays.sort(nums);
    dfs(result, new Stack(), nums);
    return result;
  }

  @Test
  public void test() {
    System.out.println(permuteUnique(new int[]{1, 1, 2, 2}));
  }

}
