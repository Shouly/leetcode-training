package me.shouly.leetcode.training.multithread;

import java.util.concurrent.TimeUnit;

/**
 * .
 *
 * @author liangbing
 * @version v1.0
 * @date 2019-07-23 16:54
 */
public class ThreadInterruptedTest {

  static class InterruptedThread implements Runnable {
    @Override
    public void run() {
      for (; ; ) ;
    }
  }

  public static void main(String[] args) throws Exception {

    Thread t = new Thread(new InterruptedThread());

    t.start();

    TimeUnit.SECONDS.sleep(2);

    System.out.println(t.isInterrupted());

    t.interrupt();

    System.out.println(t.isInterrupted());
  }
}
