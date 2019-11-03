package MultiThread;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-10-08 22:15
 **/
public class CyclicBarrierTest {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier (7, new Thread (() -> {
            System.out.println ("龙珠集齐，召唤神龙");
        }, ""));

        Data data = new Data (barrier);
        for (int i = 0; i < 7; i++) {
            final int t = i;
            new Thread (() -> {
                try {
                    data.doWork (t + 1);
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace ();
                }
            }, "").start ();
        }
    }

}

class Data {
    Random rand = new Random ();
    CyclicBarrier barrier;

    public Data(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    public void doWork(int i) throws InterruptedException, BrokenBarrierException {
        TimeUnit.MILLISECONDS.sleep (rand.nextInt (2000));
        System.out.println (i + "th Dragon Ball is Done!");
        barrier.await ();
    }
}
