package MultiThread.consumerproducer;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-10-08 19:30
 **/

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1、 线程    操作   资源类
 * 2、 判断    执行   通知
 * 3、 防止虚假唤醒机制
 */
public class SynWaitNotify {
    public static void main(String[] args) {
        ShareData data = new ShareData ();
        new Thread (() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment ();
                } catch (Exception e) {
                    e.printStackTrace ();
                }
            }
        }, "AA").start ();
        new Thread (() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement ();
                } catch (Exception e) {
                    e.printStackTrace ();
                }
            }
        }, "BB").start ();
    }
}

class ShareData {
    private int number = 0;
    private Lock lock = new ReentrantLock ();
    private Condition condition = lock.newCondition ();

    public void increment() throws Exception {
        lock.lock ();
        try {
            while (number == 5) {
                // 等待
                condition.await ();
            }
            // 可以执行
            number++;
            System.out.println (Thread.currentThread ().getName () + "\t" + number);
            // 通知唤醒
            condition.signalAll ();
        } finally {
            lock.unlock ();
        }
    }

    public void decrement() throws Exception {
        lock.lock ();
        try {
            while (number == 0) {
                // 等待
                condition.await ();
            }
            // 可以执行
            number--;
            System.out.println (Thread.currentThread ().getName () + "\t" + number);
            // 通知唤醒
            condition.signalAll ();
        } finally {
            lock.unlock ();
        }
    }
}