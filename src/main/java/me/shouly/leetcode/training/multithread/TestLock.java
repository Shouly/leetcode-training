package me.shouly.leetcode.training.multithread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * .
 *
 * @author liangbing
 * @version v1.0
 * @date 2019-07-18 15:31
 */
public class TestLock {

  Lock lock = new ReentrantLock();

  public void test() {
    try {
      lock.lock();

      Thread.sleep(60000);

    } catch (Exception e) {

    } finally {
      lock.unlock();
    }
  }

  public static void main(String[] args) throws Exception {
    TestLock testLock = new TestLock();
    Thread t1 = new Thread(() -> testLock.test());
    Thread t2 = new Thread(() -> testLock.test());
    Thread t3 = new Thread(() -> testLock.test());
    Thread t4 = new Thread(() -> testLock.test());

    t1.start();
    t2.start();
    t3.start();
    t4.start();

    t1.join();
    t2.join();
    t3.join();
    t4.join();
  }
}
