package me.shouly.leetcode.training.hard;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedHashMap;

/**
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。
 *
 * <p>返回滑动窗口最大值。
 *
 * @author liangbing
 * @version v1.0
 * @date 2019-07-16 16:53
 */
public class No_239_MaxSlidingWindow {

  public static int[] maxSlidingWindow(int[] nums, int k) {

    int size = nums.length;

    if (size * k == 0) {
      return new int[0];
    }

    if (k == 1) {
      return nums;
    }

    Deque<Integer> window = new ArrayDeque<>();

    int maxIndex = 0;

    for (int i = 0; i < k; i++) {

      if (!window.isEmpty() && (window.getFirst() == i - k)) {
        window.removeFirst();
      }

      while (!window.isEmpty() && nums[i] > window.getLast()) {
        window.removeLast();
      }

      window.addLast(i);

      if (nums[i] > nums[maxIndex]) {
        maxIndex = i;
      }
    }

    int[] result = new int[size - k + 1];

    result[0] = nums[maxIndex];

    for (int i = k; i < size; i++) {
      if (!window.isEmpty() && (window.getFirst() == i - k)) {
        window.removeFirst();
      }

      while (!window.isEmpty() && nums[i] > window.getLast()) {
        window.removeLast();
      }

      window.addLast(i);
      result[i - k + 1] = nums[window.getFirst()];
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3)));
  }
}
