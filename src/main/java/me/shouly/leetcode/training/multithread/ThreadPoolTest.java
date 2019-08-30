package me.shouly.leetcode.training.multithread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * .
 *
 * @author liangbing
 * @version v1.0
 * @date 2019-08-19 14:55
 */
public class ThreadPoolTest {

  public static void main(String[] args) {

    ExecutorService pool =
        new ThreadPoolExecutor(
            0,
            1,
            60L,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(1),
            //            r -> {
            //              Thread t = new Thread();
            //              // t.setDaemon(true);
            //              return t;
            //            },
            new ThreadPoolExecutor.CallerRunsPolicy());

    pool.submit(
        () -> {
          System.out.println(Thread.currentThread().getName() + "--1");
          try {
            TimeUnit.SECONDS.sleep(1);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        });

    pool.submit(
        () -> {
          System.out.println(Thread.currentThread().getName() + "--2");
          try {
            TimeUnit.SECONDS.sleep(1);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        });
    pool.submit(
        () -> {
          System.out.println(Thread.currentThread().getName() + "----");
        });
    // pool.shutdown();
  }
}
