package me.shouly.leetcode.training.easy;

import java.util.Iterator;
import java.util.TreeMap;

/**
 * .
 *
 * @author liangbing
 * @version v1.0
 * @date 2019-07-17 11:37
 */
public class BinarySearchTree<T> {

  private Node<T> root;

  class Node<T> {
    T data;
    Node<T> left;
    Node<T> right;
  }

  public BinarySearchTree() {
    root = null;
  }

  public BinarySearchTree(BinarySearchTree.Node root) {
    this.root = root;
  }

  public void preOrder(Node<T> root) {

    if (root != null) {

      System.out.println(root);

      preOrder(root.left);
      preOrder(root.right);
    }
  }

}
