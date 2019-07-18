package me.shouly.leetcode.training.medium;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import sun.misc.LRUCache;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * <p>获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。 写入数据 put(key, value) -
 * 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间.
 *
 * @author liangbing
 * @version v1.0
 * @date 2019-07-18 11:40
 */
public class No_146_LRUCache {

  class LRUCache extends LinkedHashMap<Integer, Integer> {

    volatile int capacity;

    public LRUCache(int capacity) {
      super(capacity, 0.75f, true);
      this.capacity = capacity;
    }

    public int get(int key) {
      return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
      super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
      return size() > capacity;
    }
  }

  public static void main(String[] args) {

    Map<Integer, Object> cache = new LinkedHashMap<>(3, 0.75f, true);

    cache.put(1, 1);
    cache.put(2, 1);
    cache.put(3, 1);

    cache.get(3);
    cache.get(2);

    Iterator<Map.Entry<Integer, Object>> it = cache.entrySet().iterator();
    while (it.hasNext()) {
      System.out.println(it.next().getKey());
    }
  }
}
