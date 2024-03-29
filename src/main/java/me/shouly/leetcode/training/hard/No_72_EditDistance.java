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

  public static int minDistance(String word1, String word2) {

    int n1 = word1.length();
    int n2 = word2.length();
    int[][] dp = new int[n1 + 1][n2 + 1];
    // 第一行
    for (int j = 1; j <= n2; j++) dp[0][j] = dp[0][j - 1] + 1;
    // 第一列
    for (int i = 1; i <= n1; i++) dp[i][0] = dp[i - 1][0] + 1;

    for (int i = 1; i <= n1; i++) {
      for (int j = 1; j <= n2; j++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
        else dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
      }
    }
    return dp[n1][n2];
  }

  public static void main(String[] args) {
    System.out.println(minDistance("hello", "xxxxxx"));
  }
}
