package src.String;

public class Kmp {

    public static void main(String[] args) {
        String str = "abababca";
        char[] chars = str.toCharArray();
        print(getNext(chars));
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    static int kmp(char[] mainStr, char[] pattern, int[] next) {
        int i = 0;
        int j = 0;
        while (i < mainStr.length && j < pattern.length) {
            if (mainStr[i] == pattern[j]) {
                i++;
                j++;
            } else {
                j = next[i - 1];
            }
        }
        if (j == pattern.length) {
            return i - j;
        } else {
            return -1;
        }
    }

    static int[] getNext(char[] mainStr) {
        int i = 1;
        int j = 0;
        int[] result = new int[mainStr.length];
        while (i < mainStr.length) {
            if (mainStr[i] == mainStr[j]) {
                j = j + 1;
                result[i] = j;
                i++;
            } else {
                j = 0;
                i++;
            }
        }
        return result;
    }

}
