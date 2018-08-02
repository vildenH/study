package src.Array;

//统计一个数字在排序数组中出现的次数。
public class GetNumberOfK {

    public int findFirst(int[] array, int start, int end, int key) {

        while (start <= end) {
            int mid = (start + end) >> 1;
            if (array[mid] == key) {
                if (mid == 0 || (array[mid - 1] != array[mid])) {
                    return mid;
                } else {
                    end = mid - 1;
                }
            }
            if (array[mid] < key) {
                start = mid + 1;
            } else if (array[mid] > key) {
                end = mid - 1;
            }
        }

        return -1;
    }

    public int findLast(int[] array, int start, int end, int key) {
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (array[mid] == key) {
                if (mid == array.length - 1 || (array[mid + 1] != array[mid])) {
                    return mid;
                } else {
                    start = mid + 1;
                }
            }
            if (array[mid] < key) {
                start = mid + 1;
            } else if (array[mid] > key) {
                end = mid - 1;
            }
        }

        return -1;
    }

    public int getNumberOfK(int[] array, int k) {

        int firstIndex = findFirst(array, 0, array.length - 1, k);
        int lastIndex = findLast(array, 0, array.length - 1, k);
        if (firstIndex == -1)      //没有在数组中找到该数
        {
            return 0;
        }
        int count = lastIndex - firstIndex + 1;
        return count;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 3, 3, 3};
        System.out.println(new GetNumberOfK().findFirst(array, 0, array.length - 1, 3));
        System.out.println(new GetNumberOfK().findLast(array, 0, array.length - 1, 3));


    }
}
