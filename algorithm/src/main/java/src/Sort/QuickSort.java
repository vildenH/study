package src.Sort;

import java.util.Random;
import java.util.Stack;

public class QuickSort {
    public static void randomKey(int[] num, int left, int right) {
        int keyIndex = new Random().nextInt(right - left) + left;
        int temp = num[left];
        num[left] = num[keyIndex];
        num[keyIndex] = temp;
    }

    public static int part(int[] num, int left, int right) {
        int low = left;
        int high = right;
        randomKey(num, left, right);
        int key = num[low];
        while (low < high) {
            while (low < high && num[high] >= key) {
                high--;
            }
            num[low] = num[high];
            while (low < high && num[low] <= key) {
                low++;
            }
            num[high] = num[low];

        }
        num[low] = key;
        return low;
    }

    public static int part2(int[] num, int left, int right) {
        int i = left - 1;
        int key = num[right];
        for (int j = left; j <= right - 1; j++) {
            if (num[j] <= key) {
                i++;
                if (i != j) {
                    int temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;
                }
            }
        }
        int temp = num[i + 1];
        num[i + 1] = num[right];
        num[right] = temp;
        return i + 1;

    }

    public static void quickSort(int[] num, int left, int right) {

        if (left > right) {
            return;
        }

        int mid = part2(num, left, right);
        quickSort(num, left, mid - 1);
        quickSort(num, mid + 1, right);

    }

    public static void nonRecursiveQuickSort(int[] a) {
        //存放开始与结束索引
        Stack<Integer> s = new Stack<Integer>();
        //压栈
        s.push(0);
        s.push(a.length - 1);
        //利用循环里实现
        while (!s.empty()) {
            int right = s.pop();
            int left = s.pop();
            if (right < left) {
                continue;
            }
            int i = part(a, left, right);
            if (left < i - 1) {
                s.push(left);
                s.push(i - 1);
            }
            if (i + 1 < right) {
                s.push(i + 1);
                s.push(right);
            }
        }
    }

    public static void nonRecursiveQuickSort(int[] num, int left, int right) {
        Stack<Integer> stack = new Stack<>();
        stack.push(left);
        stack.push(right);
        while (!stack.empty()) {
            int high = stack.pop();
            int low = stack.pop();
            if (low > high) {
                continue;
            }
            int mid = part(num, low, high);
            if (low < mid - 1) {
                stack.push(low);
                stack.push(mid - 1);
            }
            if (high > mid + 1) {
                stack.push(mid + 1);
                stack.push(high);
            }
        }
    }

}
