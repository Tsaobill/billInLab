package MultiThread.consumerproducer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-10-08 20:53
 **/
public class RoundRobinPrint {
    public static void main(String[] args) {
        Printer printer = new Printer ();

        new Thread (() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    printer.printA ();
                } catch (Exception e) {
                    e.printStackTrace ();
                }
            }
        }).start ();

        new Thread (() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    printer.printB ();
                } catch (Exception e) {
                    e.printStackTrace ();
                }
            }
        }).start ();

        new Thread (() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    printer.printC ();
                } catch (Exception e) {
                    e.printStackTrace ();
                }
            }
        }).start ();
    }
}

class Printer {
    Lock lock = new ReentrantLock ();
    Condition acon = lock.newCondition ();
    Condition bcon = lock.newCondition ();
    Condition ccon = lock.newCondition ();
    int flag = 0;

    public void printA() throws Exception {
        lock.lock ();
        try {
            while (flag % 3 != 0) {
                acon.await ();
            }
            for (int i = 0; i < 5; i++) {
                System.out.print ("AA ");
            }
            flag++;
            bcon.signalAll ();
        } finally {
            lock.unlock ();
        }
    }

    public void printB() throws InterruptedException {
        lock.lock ();
        try {
            while (flag % 3 != 1) {
                bcon.await ();
            }
            for (int i = 0; i < 10; i++) {
                System.out.print ("BB ");
            }
            flag++;
            ccon.signal ();
        } finally {
            lock.unlock ();
        }
    }

    public void printC() throws InterruptedException {
        lock.lock ();
        try {
            while (flag % 3 != 2) {
                ccon.await ();
            }
            for (int i = 0; i < 15; i++) {
                System.out.print ("CC ");
            }
            System.out.println ();
            flag++;
            acon.signal ();
        } finally {
            lock.unlock ();
        }
    }
}