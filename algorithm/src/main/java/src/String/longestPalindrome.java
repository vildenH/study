package src.String;

import org.junit.Test;

/**
 * @author wh
 * @date 2019/11/8
 */
public class longestPalindrome {

  public String findLongestPalindrome(String s) {
    char[] strs = s.toCharArray();
    String result = "";

    int maxCount = 0;
    for (int i = 0; i < strs.length; i++) {
      int count = 1;
      int count2 = 0;

      int left = i - 1;
      int right = i + 1;
      // 奇数情况
      while (true) {
        if (left >= 0 && right < strs.length) {
          if (strs[left] == strs[right]) {
            int temp = count + 2;
            count = count + 2;
            if (temp >= maxCount) {
              maxCount = temp;
              result = new String(s.substring(left, right + 1));
            }
          }else {
            break;
          }
          left--;
          right++;
        } else {
          break;
        }
      }
      int left2 = i;
      int right2 = i + 1;
      // 偶数情况
      while (true) {
        if (left2 >= 0 && right2 < strs.length) {
          if (strs[left2] == strs[right2]) {
            int temp = count2 + 2;
            count2 = count2 + 2;
            if (temp >= maxCount) {
              maxCount = temp;
              result = new String(s.substring(left2, right2 + 1));
            }
          }else{
            break;
          }
          left2--;
          right2++;
        } else {
          break;
        }
      }
    }
    if (maxCount == 0) {
      return String.valueOf(s.charAt(s.length() - 1));
    }
    return result;
  }

  @Test
  public void test() {
    System.out.println(findLongestPalindrome("abcda"));
  }
}
