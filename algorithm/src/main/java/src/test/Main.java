package src.test;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        int n;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        for (int i = 0; i < n; i++) {
            long ans = 0;
            StringBuffer path = new StringBuffer();
            int num = in.nextInt();
            int[][] bushu = new int[4][num];
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < num; k++) {
                    bushu[j][k] = in.nextInt();
                }
            }
            for (int k = 0; k < num; k++) {
                int temp = 0;
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < 4; j++) {

                    if (bushu[j][k] < min) {
                        min = bushu[j][k];
                        temp = j;
                    }
                }
                ans = ans + min;
                if (temp == 0) {
                    path.append("E");
                } else if (temp == 1) {
                    path.append("S");
                } else if (temp == 2) {
                    path.append("W");
                } else if (temp == 3) {
                    path.append("N");
                }
            }
            System.out.println(ans);
            System.out.println(path.toString());

        }

    }
}
