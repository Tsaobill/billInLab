package MultiThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-25 21:24
 **/
public class souhu {

    private static Lock lock = new ReentrantLock ();
    private static Condition A = lock.newCondition ();
    private static Condition B = lock.newCondition ();
    private static Condition C = lock.newCondition ();
    private static int count = 1;
    private static int add = 0;
    private static int idx = 0;
    private static char aChar = 'A';


    static class ThreadA extends Thread {
        @Override
        public void run() {
            try {
                lock.lock ();
                while (add <= 52) {
                    while (add % 2 != 0)//注意这里是不等于0，也就是说在count % 3为0之前，当前线程一直阻塞状态
                        A.await (); // A释放lock锁
                    System.out.print (count++);
                    System.out.print (count++);
                    add++;
                    B.signal (); // A执行完唤醒B线程
                }
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
                while (add <= 52) {
                    while (add % 2 != 1)
                        B.await ();// B释放lock锁，当前面A线程执行后会通过B.signal()唤醒该线程
                    System.out.print ((char) (aChar + idx) + " ");
                    idx++;
                    add++;
                    idx %= 26;
                    A.signal ();// B执行完唤醒C线程
                }
            } catch (InterruptedException e) {
                e.printStackTrace ();
            } finally {
                lock.unlock ();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        new ThreadA ().start ();
        new ThreadB ().start ();
    }
}
