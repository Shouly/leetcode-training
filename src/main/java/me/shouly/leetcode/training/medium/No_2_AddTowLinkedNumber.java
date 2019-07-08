package me.shouly.leetcode.training.medium;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * <p>如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * <p>您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * <p>示例：
 *
 * <p>输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) 输出：7 -> 0 -> 8 原因：342 + 465 = 807
 *
 * @author liangbing
 * @version v1.0
 * @date 2019-07-08 15:26
 */
public class No_2_AddTowLinkedNumber {

  public ListNode addTowNumbers(ListNode l1, ListNode l2) {

    ListNode result = new ListNode(0);

    ListNode cp = result;

    ListNode cp2 = result;

    while (l1 != null && l2 != null) {
      result = perNodeSum(result, l1.val, l2.val);
      l1 = l1.next;
      l2 = l2.next;
    }

    while (l1 != null) {
      result = perNodeSum(result, l1.val, 0);
      l1 = l1.next;
    }

    while (l2 != null) {
      result = perNodeSum(result, 0, l2.val);
      l2 = l2.next;
    }

    while (cp.next != null && cp.next.next != null) {
      cp = cp.next;
    }

    if (cp.next.val == 0) {
      cp.next = null;
    }

    return cp2;
  }

  private ListNode perNodeSum(ListNode result, int l1Val, int l2Val) {

    int sum = l1Val + l2Val + result.val;
    if (sum >= 10) {
      result.val = sum % 10;
      ListNode next = new ListNode(1);
      result.next = next;
    } else {
      ListNode next = new ListNode(0);
      result.val = sum;
      result.next = next;
    }

    return result.next;
  }

  /** 单链表 */
  class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
      this.val = val;
    }

    @Override
    public String toString() {
      return this.val + (next == null ? "" : "->" + next.toString());
    }
  }

  public static void main(String[] args) {
    No_2_AddTowLinkedNumber t = new No_2_AddTowLinkedNumber();

    ListNode l1 = t.new ListNode(8);
    ListNode l1n = t.new ListNode(9);
    l1.next = l1n;
    ListNode l1nn = t.new ListNode(3);
    l1n.next = l1nn;
    ListNode l2 = t.new ListNode(2);

    System.out.println(l1);
    System.out.println(l2);

    System.out.println(t.addTowNumbers(l1, l2));
  }
}
