package src.Array;

//调整数组顺序使奇数位于偶数前面
public class ReOrderArray {
    public void reOrderArray(int[] array) {

        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1) {
                for (int j = i; j > 0; j--) {
                    if ((array[j - 1] & 1) == 0) {
                        int temp = array[j - 1];
                        array[j - 1] = array[j];
                        array[j] = temp;

                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        new ReOrderArray().reOrderArray(array);
        for (int num : array) {
            System.out.println(num);
        }
    }
}
