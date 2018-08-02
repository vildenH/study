package src.Array;

//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
// 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
// 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0
public class MoreThanHalfNum_Solution {
    public static int moreThanHalfNum_Solution(int[] array) {
        if (array == null) {
            return 0;
        }
        int now = 0;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                now = array[i];
                count++;
                continue;
            }
            if (array[i] != now) {
                if (count >= 1)
                    count--;
                else {
                    now = array[i];

                }
            } else {
                count++;
            }

        }
        if (count >= 1)
            return now;
        else {
            return 0;
        }
    }

    public static int moreThanHalfNum_Solution2(int[] array) {

        if (array == null) {
            return 0;
        }
        int mid = array.length >> 1;
        int start = 0;
        int end = array.length - 1;
        int index = part(array, 0, array.length);
        while (index != mid) {
            if (index > mid) {
                end = index - 1;
                index = part(array, start, end);
            } else {
                start = index + 1;
                index = part(array, start, end);
            }
        }
        int result = array[mid];

        return result;
    }

    public static int part(int[] array, int start, int end) {
        if (start > end) {
            return -1;
        }
        int key = array[start];
        int left = start;
        int right = end;
        while (left < right) {
            while (left < right && array[right] > key) {
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] < key) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = key;
        return left;

    }

    public static void main(String[] args) {
        int[] array = {2, 2, 2, 2, 2, 1, 3, 4, 5};
        System.out.println(MoreThanHalfNum_Solution.moreThanHalfNum_Solution(array));
    }
}
