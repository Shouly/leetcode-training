package me.shouly.leetcode.training.hard;

/**
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * <p>你可以对一个单词进行如下三种操作：
 *
 * <p>插入一个字符 删除一个字符 替换一个字符
 *
 * <p>示例 1:
 *
 * <p>输入: word1 = "horse", word2 = "ros" 输出: 3 解释: horse -> rorse (将 'h' 替换为 'r') rorse -> rose (删除
 * 'r') rose -> ros (删除 'e')
 *
 * <p>示例 2:
 *
 * <p>输入: word1 = "intention", word2 = "execution" 输出: 5 解释: intention -> inention (删除 't') inention
 * -> enention (将 'i' 替换为 'e') enention -> exention (将 'n' 替换为 'x') exention -> exection (将 'n' 替换为
 * 'c') exection -> execution (插入 'u')
 *
 * @author liangbing
 * @version v1.0
 * @date 2019-07-16 10:44
 */
public class No_72_EditDistance {

  public int minDistance(String word1, String word2) {

    int n = word1.length();
    int m = word2.length();

    // if one of the strings is empty
    if (n * m == 0) {
      return n + m;
    }

    // array to store the convertion history
    int[][] d = new int[n + 1][m + 1];

    // init boundaries
    for (int i = 0; i < n + 1; i++) {
      d[i][0] = i;
    }
    for (int j = 0; j < m + 1; j++) {
      d[0][j] = j;
    }

    // DP compute
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < m + 1; j++) {

        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          d[i][j] = d[i - 1][j - 1];
        } else {
          int insert = d[i][j - 1];
          int delete = d[i - 1][j];
          int replace = d[i - 1][j - 1];
          d[i][j] = Math.min(insert, Math.min(delete, replace)) + 1;
        }
      }
    }
    return d[n][m];
  }
}
