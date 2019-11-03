package MultiThread;

import javafx.css.Size;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-10-07 14:36
 **/
class TaskPortion implements Runnable {
    private static int count = 0;
    final int id = count++;
    static Random rand = new Random (47);
    final CountDownLatch latch;

    public TaskPortion(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            doWork ();
            latch.countDown ();
//            System.out.println ("If you see me that means \" CountDownLatch doesn't block");
        } catch (InterruptedException e) {

        }
    }

    public void doWork() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep (rand.nextInt (2000));
        System.out.println (this + "completed");
    }

    @Override
    public String toString() {
        return String.format ("%1$-3d ", id);
    }
}

class WaitingTask implements Runnable {
    static int count = 0;
    final int id = count++;
    final CountDownLatch latch;

    public WaitingTask(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            System.out.println ("Latch barrier blocked for " + this);
            latch.await ();
            System.out.println ("Latch barrier passed for " + this);
        } catch (InterruptedException e) {
            System.out.println (this + " interrupted");
        }
    }

    @Override
    public String toString() {
        return String.format ("WaitingTask %1$-3d", id);
    }
}

public class CountDownLatchTest {
    static final int SIZE = 100;

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool ();
        CountDownLatch latch = new CountDownLatch (SIZE);
        for (int i = 0; i < 10; i++) {
            exec.execute (new WaitingTask (latch));
        }
        for (int i = 0; i < SIZE; i++) {
            exec.execute (new TaskPortion (latch));
        }
        System.out.println ("Launched all tasks");
        exec.shutdown ();

    }
}
