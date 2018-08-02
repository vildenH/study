package src.Sort;

public class MergeSort {

    public static void merge(int nums[], int left, int mid, int right) {
        int i = left, j = mid; //数组A的起始点
        int n = mid + 1, m = right;   //数组B的起始点
        int temp[] = new int[(right - left) + 1];
        int k = 0;
        while (i <= j && n <= m) {
            if (nums[i] < nums[n])
                temp[k++] = nums[i++];
            else
                temp[k++] = nums[n++];
        }
        while (i <= j) {
            temp[k++] = nums[i++];
        }
        while (n <= m) {
            temp[k++] = nums[n++];
        }
        for (int count = 0; count < right - left + 1; count++) {
            nums[left + count] = temp[count];
        }

    }

    public static void merge2(int nums[], int left, int mid, int right) {
        int i = left, j = mid + 1;
        int[] temp = new int[right - left + 1];
        int k = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= right) {
            temp[k++] = nums[j++];
        }
        for(int count=0;count<(right-left+1);count++)
        {
            nums[left+count]=temp[count];
        }
    }

    public static void mergeSort(int nums[], int left, int right) {
        if (nums == null) {
            return;
        }
        if (left >= right) {
            return;
        }
        int mid = (left + right) >> 1;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge2(nums, left, mid, right);

    }
}
