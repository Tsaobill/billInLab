package MultiThread.consumerproducer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-10-08 21:12
 **/
public class BQueue {
    public static void main(String[] args) {
        DataResource dataResource = new DataResource (new ArrayBlockingQueue<> (6));
        new Thread (() -> {
            System.out.println ("生产现场启动");
            try {
                dataResource.produce ();
            } catch (Exception e) {
                e.printStackTrace ();
            }
        }, "").start ();

        new Thread (() -> {
            System.out.println ("消费现场启动");
            System.out.println ();
            System.out.println ();
            System.out.println ();
            try {
                dataResource.consume ();
            } catch (Exception e) {
                e.printStackTrace ();
            }
        }, "").start ();

        try {
            TimeUnit.SECONDS.sleep (5L);
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }

        dataResource.stop ();
    }


}

class DataResource {
    private volatile boolean flag = true;
    private AtomicInteger integer = new AtomicInteger ();

    BlockingQueue<String> blockingQueue = null;

    public DataResource(BlockingQueue<String> blockingQueue) {
        System.out.println (blockingQueue.getClass ().getName ());
        this.blockingQueue = blockingQueue;
    }

    public void produce() throws Exception {
        for (int i = 0; i < 40; i++) {
            int n = integer.incrementAndGet ();
            boolean res = blockingQueue.offer (n + " ", 2L, TimeUnit.SECONDS);
            if (res) {
                System.out.println ("生产成功：" + n);
            }
//            try {
//                TimeUnit.SECONDS.sleep (1L);
//            } catch (InterruptedException e) {
//                e.printStackTrace ();
//            }
        }
        System.out.println ("flag = " + flag + " quit");

    }

    public void consume() throws Exception {
        while (true) {
            String ans = blockingQueue.poll (2L, TimeUnit.SECONDS);
            if (ans == null || ans.equalsIgnoreCase ("")) {
                System.out.println ("消费超时，即将退出");
                return;
            }
            System.out.println ("消费成功：" + ans);
        }
    }

    public void stop() {
        flag = false;
    }
}
