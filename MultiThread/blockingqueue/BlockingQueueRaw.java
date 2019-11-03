package MultiThread.blockingqueue;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-07-20 20:36
 **/
public class BlockingQueueRaw {

    // 用来保存元素的数组
    private final Object[] items;

    // 容量
    private  int capacity;

    // 弹出元素下标
    private  int takeIndex;

    // 插入元素下标
    private int putIndex;

    // 当前队列中的元素个数
    // count == items.length说明队列已满
    // count == 0 说明队列为空
    private int count;




    public BlockingQueueRaw(int capacity) {
        if (capacity <= 0 )
            throw new IllegalArgumentException ();
        this.capacity = capacity;
        items = new Object[capacity];
    }

    /**
     * put方法 向队列末尾添加新元素
     * @param e 新元素
     * @throws InterruptedException
     */
    public void put(Object e) throws InterruptedException{
        while (true){
            synchronized (this) {
                // 直到队列未满才执行入队操作并跳出循环
                if (count != items.length) {
                    enqueue (e);
                    break;
                }
            }
            // 队列已满
            System.out.println ("队列已满，入队阻塞");
            Thread.sleep (200L);
        }
    }

    public Object take() throws InterruptedException{
        while (true){
            synchronized (this) {
                // 直到队列不为空 执行出队并退出循环
                if (count != 0) {
                    return dequeue ();
                }
            }
            // 队列未为空
            System.out.println ("队列为空，出队阻塞");
            Thread.sleep (200L);
        }
    }

    /**
     * 入队方法
     * @param e 当入队元素
     */
    private void enqueue(Object e){
        items[putIndex] = e;
        if(++putIndex == items.length)
            putIndex = 0;

        count++;
    }

    /**
     * 出队方法
     * @return 出队元素
     */
    private Object dequeue(){
        Object e = items[takeIndex];
        items[takeIndex] = null;

        if(++takeIndex == items.length)
            takeIndex = 0;

        count--;
        return e;
    }
}
