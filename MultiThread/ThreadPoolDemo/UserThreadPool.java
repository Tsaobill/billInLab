package MultiThread.ThreadPoolDemo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-08-21 22:16
 **/
public class UserThreadPool {
    public static void main(String[] args) {
        BlockingQueue queue = new LinkedBlockingDeque (2);

        UserThreadFactory f1 = new UserThreadFactory ("第1机房");
        UserThreadFactory f2 = new UserThreadFactory ("第2机房");

        UserRejectedExecutionHandler handler = new UserRejectedExecutionHandler ();

        ThreadPoolExecutor poolExecutorFirst =
                new ThreadPoolExecutor (1, 2, 60,
                        TimeUnit.SECONDS, queue, f1, handler);

        ThreadPoolExecutor poolExecutorSec =
                new ThreadPoolExecutor (1, 2, 60,
                        TimeUnit.SECONDS, queue, f2, handler);

        Runnable task = new Task ();
        for (int i = 0; i < 20; i++) {
            poolExecutorFirst.execute (task);
            poolExecutorSec.execute (task);

        }
    }
}
