package src;

/**
 * @author wh
 * @date 2019/3/6
 */
public class Main {

  public static String countAndSay(int n) {
    if (n <= 0) {
      return "";
    }
    if (n == 1) {
      return "1";
    }
    String result = "1";
    for (int i = 0; i < n-1; i++) {
      result = countAndSay(result);
    }
    return result;
  }


  public static void main(String[] args) {
    System.out.println(countAndSay(5));
  }

  public static String countAndSay(String str) {
    char[] chs = str.toCharArray();
    String result = "";
    int count = 0;
    for (int i = 0; i < chs.length; ) {
      char srcChar = chs[i];
      for (int j = i; j < chs.length; j++) {
        if (srcChar != chs[j]) {
          break;
        } else {
          count++;
        }
      }
      result += count;
      result += srcChar;
      i = i + count;
      count = 0;
    }
    return result;
  }
}
