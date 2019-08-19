package me.shouly.leetcode.training.multithread;

import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * .
 *
 * @author liangbing
 * @version v1.0
 * @date 2019-07-18 15:17
 */
public class Test {

  public static void main(String[] args) {

    CountDownLatch countDownLatch = new CountDownLatch(2);

    CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

    Semaphore semaphore = new Semaphore(2);

    int i = 0;

    new Thread(
            () -> {
              System.out.println("t1 started.");
              try {
                Thread.sleep(1000);
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
              countDownLatch.countDown();
            })
        .start();
    new Thread(
            () -> {
              System.out.println("t2 started.");
              try {
                Thread.sleep(1000);
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
              countDownLatch.countDown();
            })
        .start();
    new Thread(
            () -> {
              System.out.println("t3 started.");
              try {
                Thread.sleep(1000);
                cyclicBarrier.await();
              } catch (Exception e) {
                e.printStackTrace();
              }
            })
        .start();

    new Thread(
            () -> {
              System.out.println("t4 started.");
              try {
                cyclicBarrier.await();
                Thread.sleep(1000);
              } catch (Exception e) {
                e.printStackTrace();
              }
            })
        .start();

    try {
      System.out.println("pre await.");
      countDownLatch.await();
      System.out.println("after await");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
