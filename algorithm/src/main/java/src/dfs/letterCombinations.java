package src.dfs;

import java.util.LinkedList;
import java.util.List;
import org.junit.Test;

/**
 * @author wh
 * @date 2019/11/6
 * leetcode 17
 */
public class letterCombinations {

  String[] phone = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

  public List<String> letterCombinations(String digits) {
    if (digits == null) {
      return new LinkedList<>();
    }
    List result = new LinkedList<>();
    dfs(result, new StringBuilder(), digits.toCharArray(), 0);
    return result;
  }

  public void dfs(List result, StringBuilder nowStr, char[] digits, int index) {
    int pos = Character.getNumericValue(digits[index]);
    if (index == digits.length - 1) {
      for (int i = 0; i < phone[pos].length(); i++) {
        result.add(nowStr.toString() + phone[pos].charAt(i));
      }
      return;
    } else {
      for (int i = 0; i < phone[pos].length(); i++) {
        dfs(result, nowStr.append(phone[pos].charAt(i)), digits, index + 1);
        nowStr.deleteCharAt(nowStr.length() - 1);
      }
    }
  }

  @Test
  public void test() {
    letterCombinations("23");
  }

}
