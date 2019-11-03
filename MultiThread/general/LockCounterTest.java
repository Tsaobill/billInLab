package MultiThread.general;

/**
 * 线程安全计数器
 * 非加锁 CAS
 *
 * @version 1.0
 * @created by bill
 * @on 2019-09-21 14:28
 **/
public class LockCounterTest {
    static LockCounter counter = new LockCounter ();
    static String lock = " ";
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread (new Runnable () {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        synchronized (lock) {
                            counter.increase ();
                        }
                    }
                }
            }).start ();
        }
        while (Thread.activeCount () > 1) {
            Thread.yield ();
        }
        System.out.println (counter.getAndIncrease ());
    }

}

class LockCounter {
    int count;
    String lock = " ";

    public void increase() {
        count++;
    }

    public int getAndIncrease() {
        return count++;
    }
}
