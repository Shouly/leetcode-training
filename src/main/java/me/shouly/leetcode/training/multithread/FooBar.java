package me.shouly.leetcode.training.multithread;

/**
 * .
 *
 * @author liangbing
 * @version v1.0
 * @date 2019-07-22 12:07
 */
public class FooBar {

  private int n;

  private boolean isFoo;

  public FooBar(int n) {
    this.n = n;
    this.isFoo = false;
  }

  public void foo(Runnable printFoo) throws InterruptedException {

    for (int i = 0; i < n; i++) {

      synchronized (this) {
        while (isFoo) {
          this.wait();
        }
        // printFoo.run() outputs "foo". Do not change or remove this line.
        printFoo.run();
        isFoo = true;
        this.notifyAll();
      }
    }
  }

  public void bar(Runnable printBar) throws InterruptedException {

    for (int i = 0; i < n; i++) {

      synchronized (this) {
        while (!isFoo) {
          this.wait();
        }
        // printBar.run() outputs "bar". Do not change or remove this line.
        printBar.run();
        isFoo = false;
        this.notifyAll();
      }
    }
  }

  public static void main(String[] args) throws InterruptedException {
    FooBar fooBar = new FooBar(5);

    fooBar.foo(new Thread());
    fooBar.bar(new Thread());
  }
}
