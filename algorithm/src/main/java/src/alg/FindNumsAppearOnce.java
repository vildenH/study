package src.alg;

//一个数组中 只有两个数字出现了一次，其他数字都出现了两次以上。
public class FindNumsAppearOnce {
    public int getBit(int num) {
        int temp = 1;
        if (temp != 0) {
            if ((temp & num) > 0) {
                return temp;
            }
            temp = temp << 1;
        }
        return temp;
    }

    public void findNumsAppearOnce(int[] array, int num1[], int num2[]) {

        if (array == null || array.length < 0) {
            return;
        }
        int x = 0;
        for (int i = 0; i < array.length; i++) {
            x = x ^ array[i];
        }
        int bit = getBit(x);
        int ans1 = 0;
        int ans2 = 0;
        for (int i = 0; i < array.length; i++) {
            if ((bit & array[i]) > 0) {
                ans1 = ans1 ^ array[i];
            } else {
                ans2 = ans2 ^ array[i];
            }
        }
        num1[0] = ans1;
        num2[0] = ans2;
    }
}
