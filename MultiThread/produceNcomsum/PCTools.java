package MultiThread.produceNcomsum;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-07-14 20:53
 **/
public class PCTools {
    public static int value = 0;
    private final String lock;

    public PCTools(String lock) {
        this.lock = lock;
    }

    public void setValue() {
        try {
            synchronized (lock) {

                while (!(PCTools.value % 2 == 0)) {
                    lock.wait ();
                }

                System.out.println (Thread.currentThread ().getName () + " : " + PCTools.value++);
                lock.notify ();
            }
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    }

    public void getValue() {
        try {
            synchronized (lock) {
                while (PCTools.value % 2 == 0) {
                    lock.wait ();
                }
                System.out.println (Thread.currentThread ().getName () + " : " + PCTools.value++);
                lock.notify ();
            }
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    }
}
