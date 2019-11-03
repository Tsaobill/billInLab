package MultiThread.ThreadPoolDemo;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-08-21 22:14
 **/
public class UserRejectedExecutionHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable task, ThreadPoolExecutor executor) {
        System.out.println ("task rejected. " + executor.toString ());
    }
}
