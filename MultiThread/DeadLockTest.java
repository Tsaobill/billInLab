package MultiThread;

import java.util.concurrent.TimeUnit;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-10-09 16:52
 **/
public class DeadLockTest {
    public static void main(String[] args) {
        String lock1 = "lock1";
        String lock2 = "lock2";
        new Thread (() -> {
            while (true) {
                synchronized (lock1) {
                    System.out.println (Thread.currentThread ().getName () + "\t" + "进入外层");
                    synchronized (lock2) {
                        System.out.println (Thread.currentThread ().getName () + "\t" + "进入内层");
                    }
                }
            }
        }, "AA").start ();
        try {
            TimeUnit.MILLISECONDS.sleep (20L);
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }

        new Thread (() -> {
            while (true) {
                synchronized (lock2) {
                    System.out.println (Thread.currentThread ().getName () + "\t" + "进入外层");
                    synchronized (lock1) {
                        System.out.println (Thread.currentThread ().getName () + "\t" + "进入内层");
                    }
                }
            }
        }, "BB").start ();
    }
}
