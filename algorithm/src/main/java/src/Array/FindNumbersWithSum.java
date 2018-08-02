package src.Array;

import java.util.ArrayList;
import java.util.HashMap;

//给定一个数组和一个sum
//找到数组中是否有一对数字和等于sum
//找出最小下标
public class FindNumbersWithSum {
    public ArrayList<Integer> findNumbersWithSum(int[] array, int sum) {
        HashMap<Integer, Boolean> map = new HashMap();
        ArrayList ans = new ArrayList();
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i]) == null) {
                map.put(array[i], true);
            }
        }
        for (int i = 0; i < array.length; i++) {
            int temp = sum - array[i];
            if (map.get(temp) != null) {
                if (array[i] < temp) {
                    ans.add(array[i]);
                    ans.add(temp);

                } else {
                    ans.add(temp);
                    ans.add(array[i]);
                }
                return ans;
            }
        }

        return ans;

    }
}