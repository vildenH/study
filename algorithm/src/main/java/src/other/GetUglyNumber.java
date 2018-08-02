package src.other;

//丑数获取
public class GetUglyNumber {
    public int GetUglyNumber_Solution(int index) {
        int count = 0;
        for (int i = 1; ; i++) {
            int num = i;
            while (num % 2 == 0) {
                num = num / 2;
            }
            while (num % 3 == 0) {
                num = num / 3;
            }
            while (num % 5 == 0) {
                num = num / 5;
            }
            if (num == 1) {
                count++;
            }
            if (count == index) {
                return i;
            }
        }
    }

    public int GetUglyNumber_Solution2(int index) {
        if (index < 0) {
            return 0;
        }
        int[] array = new int[index];
        int nowIndex = 0;
        array[nowIndex] = 1;
        nowIndex++;

        int count = 1;

        int i = 0, j = 0, k = 0;
        while (count < index) {
            int min = min(array[i] * 2, array[j] * 3, array[k] * 5);
            array[nowIndex++] = min;
            count++;
            if (min == array[i] * 2) i++;
            if (min == array[j] * 3) j++;
            if (min == array[k] * 5) k++;

        }
        return array[index - 1];

    }

    int min(int num1, int num2, int num3) {
        int min = num1 < num2 ? num1 : num2;
        return min < num3 ? min : num3;
    }

    public static void main(String[] args) {

        System.out.println(new GetUglyNumber().GetUglyNumber_Solution2(1500));

    }
}
