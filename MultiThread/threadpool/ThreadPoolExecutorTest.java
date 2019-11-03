package MultiThread.threadpool;

import java.util.concurrent.*;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-10-09 14:54
 **/
public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        System.out.println (Runtime.getRuntime ().availableProcessors ());
        ExecutorService executor = new ThreadPoolExecutor (
                2, 5,
                2L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<> (3),
                Executors.defaultThreadFactory (),
                new ThreadPoolExecutor.DiscardPolicy ()
        );

        for (int i = 0; i < 12; i++) {
            int temp = i;
            executor.execute (() -> {
                System.out.println (Thread.currentThread ().getName () + " 处理业务 " + temp);
            });
//            try {
//                TimeUnit.SECONDS.sleep (1L);
//            } catch (InterruptedException e) {
//                e.printStackTrace ();
//            }
        }

        executor.shutdown ();
    }
}
