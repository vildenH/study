package src.剑指offer;

public class Solution_6 {
    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;

            if (array[mid - 1] > mid && array[mid + 1] > mid) {
                return array[mid];
            }
            else (array[mid])
        }
    }
}
