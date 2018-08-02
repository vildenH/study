package src.Sort;

//逆序对
public class InversePairs {
    static long ans = 0;

    public static void merge(int nums[], int left, int mid, int right, int temp[]) {
        int i = left, j = mid; //数组A的起始点
        int n = mid + 1, m = right;   //数组B的起始点
        int k = 0;
        while (i <= j && n <= m) {
            if (nums[i] <= nums[n]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[n++];
                ans += (mid - i + 1);
                ans = ans % 1000000007;
            }
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

    public static void mergeSort(int nums[], int left, int right, int temp[]) {
        if (nums == null) {
            return;
        }
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid + 1, right, temp);
        merge(nums, left, mid, right, temp);

    }

    public static void main(String[] args) {
        int array[] = {3, 2, 1};
        System.out.println(new InversePairs().inversePairs(array));

    }

    public int inversePairs(int[] array) {
        int temp[] = new int[array.length];
        mergeSort(array, 0, array.length - 1, temp);
        return (int) ans;
    }
}
