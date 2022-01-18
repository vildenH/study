package src.Sort;

public class HeapSort {

    //递归方式
    public static void KeepHeap(int[] nums, int index, int length) {
        if (index > ((length - 1) / 2)) {
            return;
        }
        int leftIndex = (2 * index) + 1;
        int rightIndex = (2 * index) + 2;
        int maxIndex = index;
        if (leftIndex <= length && nums[maxIndex] < nums[leftIndex]) {
            maxIndex = leftIndex;
        }
        if (rightIndex <= length && nums[maxIndex] < nums[rightIndex]) {
            maxIndex = rightIndex;
        }
        if (maxIndex != index) {
            int temp = nums[maxIndex];
            nums[maxIndex] = nums[index];
            nums[index] = temp;
            KeepHeap(nums, maxIndex, length);
        }

        return;

    }

    // 循环方式
    public static void KeepHeap2(int[] nums, int index, int length) {
        int nowNode = index;
        while (nowNode <= (length - 1)) {
            int leftIndex = (2 * nowNode) + 1;
            int rightIndex = (2 * nowNode) + 2;
            int maxIndex = nowNode;
            if (leftIndex <= length && nums[maxIndex] < nums[leftIndex]) {
                maxIndex = leftIndex;
            }
            if (rightIndex <= length && nums[maxIndex] < nums[rightIndex]) {
                maxIndex = rightIndex;
            }
            if (maxIndex != nowNode) {
                int temp = nums[maxIndex];
                nums[maxIndex] = nums[nowNode];
                nums[nowNode] = temp;
                nowNode = maxIndex;
            } else {
                break;
            }
        }


    }

    public static void createHeap(int[] nums, int length) //length为数组最后的索引
    {
        for (int i = (length - 1) / 2; i >= 0; i--) {
            KeepHeap2(nums, i, length);
        }
    }

    public static void heapSort(int[] nums) {
        if (nums == null) {
            return;
        }
        createHeap(nums, nums.length - 1);
        int count = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;
            count++;
            KeepHeap(nums, 0, nums.length - 1 - count);

        }

    }

    public static void main(String[] args) {
        int[] nums = new int[10];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }
        HeapSort.heapSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
