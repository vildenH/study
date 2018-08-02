package src.String;
//Given a string, find the length of the longest substring without repeating characters.
//
//        Examples:
//
//        Given "abcabcbb", the answer is "abc", which the length is 3.
//
//        Given "bbbbb", the answer is "b", with the length of 1.
//
//        Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.


import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        if (s.length() == 0) {
            return 0;
        }
        int ans = 0;
        int temp = 0;
        char[] array = s.toCharArray();
        HashMap map = new HashMap();
        int left = 0, right = 0;
        for (; right < s.length(); right++) {
            if (map.containsKey(array[right])) {
                left = Math.max(left, (int) map.get(array[right]) + 1);
            }
            map.put(array[right], right);
            ans = Math.max(ans, right - left + 1);

        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abba";
        new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s);
    }
}
