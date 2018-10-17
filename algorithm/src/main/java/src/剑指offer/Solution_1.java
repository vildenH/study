package src.剑指offer;

import org.junit.Test;

/**
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Solution_1 {
    public boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }
        int row = 0;
        int col = array[0].length - 1;
        while (row < array.length && col >= 0) {
            if (target == array[row][col]) {
                return true;
            } else if (target < array[row][col]) {
                col = col - 1;
            } else if (target > array[row][col]) {
                row = row + 1;
            }

        }
        return false;
    }

    @Test
    public void test1() {
        int[][] array = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        //true
        System.out.println(new Solution_1().Find(7, array));
    }
}
