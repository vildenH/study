package src.Sort;

public class ShellSort {
    public static void shellSort(int num[]) {
        int gap = 300000;
        for (; gap >= 1; gap = gap / 3) {

            for (int j = gap; j < num.length; j = j + gap) {
                for (int k = j; k - gap >= 0; k = k - gap) {
                    if (num[k] < num[k - gap]) {
                        int temp = num[k];
                        num[k] = num[k - gap];
                        num[k - gap] = temp;
                    }
                }
            }


        }
    }
}
