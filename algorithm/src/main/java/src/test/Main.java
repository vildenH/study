package src.test;

import java.util.Arrays;

public class Main {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int result = 0;
        int fast = 1;
        int slow = 0;

        while (fast < nums.length && slow < nums.length) {
            if (slow != 0 && nums[slow] == nums[slow - 1]) {
                slow++;
                if (slow == fast) {
                    fast++;
                }
                continue;
            }
            if (nums[fast] == nums[slow] + k) {
                result = result + 1;
                slow++;
                fast++;
            } else if (nums[fast] > nums[slow] + k) {
                slow++;
                if (slow == fast) {
                    fast++;
                }
            } else {
                fast++;
                if (slow == fast) {
                    fast++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new Main().findPairs(new int[]{1, 1, 3, 4, 5}, 0);
    }
}
