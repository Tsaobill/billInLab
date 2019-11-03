package _2019秋招笔试题.tongchengyilong;

import javafx.scene.transform.Scale;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-08-29 19:18
 **/

public class Main1 {
    private static Lock lock = new ReentrantLock ();
    private static Condition A = lock.newCondition ();
    private static Condition B = lock.newCondition ();
    private static Condition C = lock.newCondition ();
    private static int count = 0;

    static class ThreadA extends Thread {
        @Override
        public void run() {
            try {
                lock.lock ();
                while (count % 3 != 0)//注意这里是不等于0，也就是说在count % 3为0之前，当前线程一直阻塞状态
                    A.await (); // A释放lock锁
                System.out.print ("_A");
                count++;
                B.signal (); // A执行完唤醒B线程
            } catch (InterruptedException e) {
                e.printStackTrace ();
            } finally {
                lock.unlock ();
            }
        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            try {
                lock.lock ();
                while (count % 3 != 1)
                    B.await ();// B释放lock锁，当前面A线程执行后会通过B.signal()唤醒该线程
                System.out.print ("_B");
                count++;
                C.signal ();// B执行完唤醒C线程
            } catch (InterruptedException e) {
                e.printStackTrace ();
            } finally {
                lock.unlock ();
            }
        }
    }

    static class ThreadC extends Thread {
        @Override
        public void run() {
            try {
                lock.lock ();
                while (count % 3 != 2)
                    C.await ();// C释放lock锁
                System.out.print ("_C");
                count++;
                A.signal ();// C执行完唤醒A线程
            } catch (InterruptedException e) {
                e.printStackTrace ();
            } finally {
                lock.unlock ();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner (System.in);
        String str = sc.nextLine ();
        System.out.print (str);
        new ThreadA ().start ();
        new ThreadB ().start ();
        new ThreadC ().start ();
    }
}