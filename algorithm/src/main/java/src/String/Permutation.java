package src.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class Permutation {
    public void dfs(char[] str, ArrayList<String> list, HashMap map) {

    }

    /*
        public ArrayList<String> permutation(String str) {
            char[] arr = str.toCharArray();
            ArrayList<String> ans = new ArrayList<>();
            return ans;
        }
    */
    public ArrayList<String> permutation(String str) {
        ArrayList<String> result = new ArrayList<String>();
        if (str == null || str.length() == 0) {
            return result;
        }

        char[] chars = str.toCharArray();
        TreeSet<String> temp = new TreeSet<>();
        permutation(chars, 0, temp);
        result.addAll(temp);
        return result;
    }

    public void permutation(char[] chars, int begin, TreeSet<String> result) {
        if (chars == null || chars.length == 0 || begin < 0 || begin > chars.length - 1) {
            return;
        }

        if (begin == chars.length - 1) {
            result.add(String.valueOf(chars));
        } else {
            for (int i = begin; i <= chars.length - 1; i++) {
                swap(chars, begin, i);

                permutation(chars, begin + 1, result);

                swap(chars, begin, i);
            }
        }
    }

    public void swap(char[] x, int a, int b) {
        char t = x[a];
        x[a] = x[b];
        x[b] = t;
    }

    public static void main(String[] args) {
        String str = "abc";
        ArrayList<String> list = new Permutation().permutation(str);
        for (String ans : list) {
            System.out.println(ans);
        }
    }
}
