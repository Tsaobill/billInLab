package MultiThread.produceNcomsum;

/**
 * 生产者线程
 *
 * @version 1.0
 * @created by bill
 * @on 2019-07-14 21:00
 **/
public class ThreadP extends Thread {
    private PCTools pcTools;

    public ThreadP(PCTools pcTools) {
        this.pcTools = pcTools;
        this.setName ("生产者");

    }

    public void run() {
        while (PCTools.value < 100) {
            pcTools.setValue ();
        }

    }
}
