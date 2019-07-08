package me.shouly.leetcode.training.easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标.
 *
 * @author liangbing
 * @version v1.0
 * @date 2019-07-08 14:50
 */
public class TowSum {

  /**
   * @param nums
   * @param target
   * @return
   */
  public int[] towSum(int[] nums, int target) {

    HashMap<Integer, Integer> cache = new HashMap<>(16);

    for (int i = 0; i < nums.length; i++) {

      if (cache.containsKey(target - nums[i])) {
        return new int[] {cache.get(target - nums[i]), i};
      }
      cache.put(nums[i], i);
    }

    return null;
  }

  public static void main(String[] args) {
    TowSum towSum = new TowSum();
    int[] nums = new int[] {2, 7, 11, 15};
    System.out.println(Arrays.toString(towSum.towSum(nums, 9)));
  }
}
