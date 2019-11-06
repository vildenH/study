package src.Array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;

/**
 * @author wh
 * @date 2019/11/6
 */
public class ThreeSum {

  public List<List<Integer>> threeSum(int[] nums) {
    if (nums == null || nums.length < 3) {
      return null;
    }
    List result = new LinkedList<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
      if (i < nums.length - 2 && i != 0 && (nums[i] == nums[i - 1])) {
        continue;
      }
      int left = i + 1;
      int right = nums.length - 1;
      int target = -nums[i];
      while (left < right) {
        if ((nums[left] + nums[right]) == target) {
          List anAns = new LinkedList<>();
          anAns.add(i);
          anAns.add(left);
          anAns.add(right);
          result.add(anAns);
          left++;
          right--;
          while (left < right && nums[left] == nums[left - 1]) {
            left++;
          }
          while (left < right && nums[right] == nums[right + 1]) {
            right--;
          }
        } else if (nums[left] + nums[right] > target) {
          right--;

        } else {
          left++;
        }
      }
    }
    return result;
  }

  @Test
  public void test() {
    threeSum(new int[]{-1, 0, 1, 2, -1, -4});
  }

}
