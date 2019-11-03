package MultiThread;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-08-29 16:32
 **/
public class SingletonAtomic {
    private static final AtomicReference<SingletonAtomic> INSTANCE = new AtomicReference<> ();

    private SingletonAtomic() {
    }

    public static SingletonAtomic getInstance() {
        for (; ; ) {
            SingletonAtomic singleton = INSTANCE.get ();
            if (singleton != null) {
                return singleton;
            }
            singleton = new SingletonAtomic ();
            if (INSTANCE.compareAndSet (null, singleton)) {
                return singleton;
            }
        }
    }
}
