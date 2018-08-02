package src.Array;
//最大子序列和
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int nowSum = 0;
        for (int i = 0; i < nums.length; i++) {
            nowSum = nowSum + nums[i];
            if (nowSum > maxSum) {
                maxSum = nowSum;
            }
            if (nowSum < 0) {
                nowSum = 0;
            }


        }
        return maxSum;
    }
}
