package MultiThread.ThreadPoolDemo;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 自定义线程工厂
 *
 * @version 1.0
 * @created by bill
 * @on 2019-08-21 21:37
 **/
public class UserThreadFactory implements ThreadFactory {
    private final String namePrefix;
    private final AtomicInteger nextId = new AtomicInteger (1);

    // 定义线程组名称，在使用jstack排查线程问题时，非常有帮助
    public UserThreadFactory(String whatFeatureOfGroup) {
        this.namePrefix = "UserThreadFactory's " + whatFeatureOfGroup
                + "-Worker-";
    }


    @Override
    public Thread newThread(Runnable task) {
        String name = namePrefix + nextId.getAndIncrement ();
        Thread thread = new Thread (null, task, name, 0, false);
        System.out.println (thread.getName ());
        return thread;
    }
}

class Task implements Runnable {
    private final AtomicLong count = new AtomicLong (0L);

    @Override
    public void run() {
        System.out.println ("running_" + count.getAndIncrement ());
    }
}