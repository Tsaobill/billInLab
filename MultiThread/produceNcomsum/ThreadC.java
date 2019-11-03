package MultiThread.produceNcomsum;

/**
 * 消费者线程
 *
 * @version 1.0
 * @created by bill
 * @on 2019-07-14 21:02
 **/
public class ThreadC extends Thread {
    private PCTools pcTools;

    public ThreadC(PCTools pcTools) {
        this.pcTools = pcTools;
        this.setName ("消费者");
    }

    public void run() {
        while (PCTools.value < 100) {
            pcTools.getValue ();
        }
    }
}
