package src.Sort;

public class SortTest {
    public static void main(String[] args) {


        int count = 100000; //倒序数组个数
        int nums[] = new int[count];
        for (int i = 0; i < count; i++) {
            nums[i] = count - i;
        }
        long startTime = System.currentTimeMillis();
        //QuickSort.quickSort(nums, 0, nums.length - 1);
        //MergeSort.mergeSort(nums, 0, nums.length - 1);
        //InsertSort.insertSort(nums);
        //ShellSort.shellSort(nums);
        //QuickSort.nonRecursiveQuickSort(nums,0,nums.length-1);
        //HeapSort.heapSort(nums);
        BubbleSort.bubbleSort(nums);
        long endTime = System.currentTimeMillis();

        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间

        for (int num : nums) {
            System.out.println(num);
        }
        //QuickSort.nonRecursiveQuickSort(nums);


    }
}
