package MultiThread.produceNcomsum;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-07-14 21:03
 **/
public class RunClass {
    public static void main(String[] args) {
        String lock = "";
        PCTools pcTools = new PCTools (lock);
        ThreadP tp = new ThreadP (pcTools);
        ThreadC tc = new ThreadC (pcTools);
        tp.start ();
        tc.start ();
    }
}
