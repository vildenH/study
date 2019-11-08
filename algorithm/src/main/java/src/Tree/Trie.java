package src.Tree;

/**
 * @author wh
 * @date 2019/11/6
 */
public class Trie {
  /*
   * @lc app=leetcode id=208 lang=java
   *
   * [208] Implement Trie (Prefix Tree)
   */

  // @lc code=start
  TrieNode root;

  /** Initialize your data structure here. */
  public Trie() {
    root = new TrieNode();
  }

  /** Inserts a word into the trie. */
  public void insert(String word) {
    TrieNode nowNode = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      int index = getCharIndex(c);
      if (nowNode.next[index] == null) {
        nowNode.next[index] = new TrieNode();
      }
      nowNode = nowNode.next[index];
    }
    nowNode.isWord = true;
  }

  public int getCharIndex(char c) {
    return c - 'a';
  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
    TrieNode nowNode = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      int index = getCharIndex(c);
      if (nowNode.next[index] == null) {
        return false;
      }
    }
    return nowNode.isWord;
  }

  /**
   * Returns if there is any word in the trie that starts with the given prefix.
   */
  public boolean startsWith(String prefix) {
    TrieNode nowNode = root;
    for (int i = 0; i < prefix.length(); i++) {
      char c = prefix.charAt(i);
      int index = getCharIndex(c);
      if (nowNode.next[index] == null) {
        return false;
      }
    }
    return true;
  }

  class TrieNode {

    TrieNode[] next = new TrieNode[26];
    boolean isWord = false;
  }
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
 * = obj.startsWith(prefix);
 */
// @lc code=end


