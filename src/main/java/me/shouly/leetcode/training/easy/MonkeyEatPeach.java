package me.shouly.leetcode.training.easy;

/**
 * 猴子吃桃子问题。猴子第一天摘下若干个桃，当即吃掉一半，又多吃一个。
 * 第二天早上又将剩下的一半吃掉一半，又多吃一个。以后每天早上都吃了
 * 前天剩下的一半零一个，到第10天早上只剩下最后一个桃。问第一天摘了几个桃。.
 *
 * @author liangbing
 * @version v1.0
 * @date 2019-08-17 15:37
 */
public class MonkeyEatPeach {

  public static void main(String[] args) {

      int sum = 1;

      for(int d = 1; d <= 9 ; d++ ){
          sum = (sum + 1) * 2;
      }

    System.out.println(sum);
  }
}
