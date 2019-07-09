package me.shouly.leetcode.training.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * <p>示例 1:
 *
 * <p>输入: "abcabcbb" 输出: 3 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * <p>示例 2:
 *
 * <p>输入: "bbbbb" 输出: 1 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * <p>示例 3:
 *
 * <p>输入: "pwwkew" 输出: 3 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *
 * <p>请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串.
 *
 * @author liangbing
 * @version v1.0
 * @date 2019-07-08 17:12
 */
public class No_3_LengthOfLongestSubStr {

  public static int lengthOfLongestSubstring(String s) {

    int length = s.length();

    Set<Character> cache = new HashSet<>();

    int i = 0;
    int j = 0;
    int result = 0;

    while (i < length && j < length) {

      if (cache.contains(s.charAt(j))) {
        cache.remove(s.charAt(i++));
      } else {
        cache.add(s.charAt(j++));
        result = Math.max(j - i, result);
      }
    }

    return result;
  }

  public static int officialAns(String s) {

    int n = s.length(), ans = 0;
    Map<Character, Integer> map = new HashMap<>(16);
    // try to extend the range [i, j]
    for (int j = 0, i = 0; j < n; j++) {
      if (map.containsKey(s.charAt(j))) {
        i = Math.max(map.get(s.charAt(j)), i);
      }
      ans = Math.max(ans, j - i + 1);
      map.put(s.charAt(j), j + 1);
    }
    return ans;
  }

  public static void main(String[] args) {
    String s = "askdfjasdk";
    System.out.println(lengthOfLongestSubstring(s));
    System.out.println(officialAns(s));
  }
}
