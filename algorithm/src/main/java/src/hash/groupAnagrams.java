package src.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wh
 * @date 2019/11/13
 */
public class groupAnagrams {

  public List<List<String>> groupAnagrams(String[] strs) {
    if (strs == null) {
      return new LinkedList<List<String>>();
    }
    List result = new LinkedList<>();
    HashMap<char[], List> map = new HashMap();
    for (String str : strs) {
      char[] chars = str.toCharArray();
      Arrays.sort(chars);
      if (!map.containsKey(String.valueOf(chars))) {
        List anAns = new LinkedList();
        anAns.add(str);
        map.put(chars, anAns);
        result.add(anAns);
      } else {
        map.get(String.valueOf(chars)).add(str);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    new groupAnagrams().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
  }

}
