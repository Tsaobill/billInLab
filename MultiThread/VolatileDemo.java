package MultiThread;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-07-05 08:26
 **/
public class VolatileDemo {
    public volatile int inc = 0;

    public void increase() {
        synchronized (this) {
            inc++;
        }
    }

    public static void main(String[] args) {
        final VolatileDemo test = new VolatileDemo ();

        for (int i = 0; i < 10; i++) {
            new Thread (() -> {
                for (int j = 0; j < 1000; j++) {
                    test.increase ();
                }
            }).start ();
        }

        while (Thread.activeCount () > 2) {
            Thread.yield ();
        }
        System.out.println (test.inc);
    }
}
