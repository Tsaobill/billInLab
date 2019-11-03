package MultiThread.singleton;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-07-15 18:35
 **/
public class Mainclass {
    public static void main(String[] args) {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread (new Runnable () {
                @Override
                public void run() {
                    MyObjext.MySingleton.INSTANCE.getConnection ();
                }
            });
            threads[i].start ();
        }
        ThreadLocal a  = new ThreadLocal ();
    }


}
