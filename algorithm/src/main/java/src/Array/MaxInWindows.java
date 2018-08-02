package src.Array;

import java.util.ArrayList;
import java.util.LinkedList;

//滑动窗口最大值
public class MaxInWindows {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> ret = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        if (num == null || num.length <= 0 || size <= 0)
            return res;
        LinkedList<Integer> indexDeque = new LinkedList<>();
        for (int i = 0; i < size - 1; i++) {
            while (!indexDeque.isEmpty() && num[i] > num[indexDeque.getLast()]) {
                indexDeque.removeLast();
            }
            indexDeque.addLast(i);
        }

        for (int i = size - 1; i < num.length; i++) {
            while (!indexDeque.isEmpty() && num[i] > num[indexDeque.getLast()]) {
                indexDeque.removeLast();
            }
            indexDeque.addLast(i);
            if (i - indexDeque.getFirst() + 1 > size) {
                indexDeque.removeFirst();
            }
            ret.add(num[indexDeque.getFirst()]);
        }
        return ret;
    }


    public static void main(String[] args) {
        int num[] = {2, 3, 4, 2, 6, 2, 5, 1,2,1};
        new MaxInWindows().maxInWindows(num, 3);

    }
}

