package src.剑指offer;

import org.junit.Assert;
import org.junit.Test;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Solution_2 {
    public String replaceSpace(StringBuffer str) {
        char[] arr = str.toString().toCharArray();
        int spaceCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                spaceCount++;
            }
        }
        char[] result = new char[arr.length + (2 * spaceCount)];
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != ' ') {
                result[i + (2 * spaceCount)] = arr[i];
            } else if (arr[i] == ' ') {
                result[i + (2 * spaceCount)] = '0';
                result[i + (2 * spaceCount) - 1] = '2';
                result[i + (2 * spaceCount) - 2] = '%';
                spaceCount--;
            }
        }
        return new String(result);
    }

    @Test
    public void test() {
        String str = "We Are Happy";
        Assert.assertEquals("We%20Are%20Happy", new Solution_2().replaceSpace(new StringBuffer(str)));
    }
}
