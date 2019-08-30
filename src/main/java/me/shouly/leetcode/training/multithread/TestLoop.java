package me.shouly.leetcode.training.multithread;

/**
 * .
 *
 * @author liangbing
 * @version v1.0
 * @date 2019-08-19 16:00
 */
public class TestLoop {

  public static void main(String[] args) {
    outer:
    for (int i = 0; i < 5; i++) {
//      if (i == 2) {
//        break outer;
//      }

      inner:
      for (int j = 1; j < 5; j++) {
//        if (j == 2) {
//          break;
//        }

        if (j == 3) {
          break outer;
        }
        System.out.println("J:"+j);
      }

      System.out.println(i);
    }
  }
}
