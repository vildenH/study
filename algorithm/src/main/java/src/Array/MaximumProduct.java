package src.Array;
//题目：给定一个数组，未排序的，找出其中三个数使其乘积最大 数字范围为-1000，1000
//解法：因为有负数的存在，所有有两种情况可能使乘积最大，一种情况两个最小负数和一个最大的正数
//另一种情况是三个号最大的正数
//将数组排序  将两种情况比较大小输出。

import java.util.Arrays;

public class MaximumProduct {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int last = nums[nums.length - 3] * nums[nums.length - 2] * nums[nums.length - 1];
        int first = nums[0] * nums[1] * nums[nums.length - 1];
        return first < last ? last : first;

    }
}
