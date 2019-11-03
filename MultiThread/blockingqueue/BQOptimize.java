package MultiThread.blockingqueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-07-20 23:08
 **/
public class BQOptimize {


    private final ReentrantLock lock = new ReentrantLock ();
    private final Condition notFull = lock.newCondition ();
    private final Condition notEmpty = lock.newCondition ();

    // 用来保存元素的数组
    private final Object[] items;

    // 容量
    private int capacity;

    // 弹出元素下标
    private int takeIndex;

    // 插入元素下标
    private int putIndex;

    // 当前队列中的元素个数
    // count == items.length说明队列已满
    // count == 0 说明队列为空
    private int count;

    public BQOptimize(int capacity) {
        this.capacity = capacity;
        items = new Object[capacity];
    }

    public void put(Object e) throws InterruptedException {
        lock.lock ();
        try {
            while (count == items.length) {
                notFull.await ();
            }
            enqueue (e);
            notFull.signalAll ();
        } finally {
            lock.unlock ();
        }
    }

    public Object take() throws InterruptedException {
        lock.lockInterruptibly ();
        try {
            while (count == 0) {
                notEmpty.await ();
            }
            Object e = dequeue ();
            notEmpty.signalAll ();
            return e;
        } finally {
            lock.unlock ();
        }
    }


    private void enqueue(Object e) {
        items[putIndex] = e;
        if (++putIndex == items.length)
            putIndex = 0;
        count++;
    }

    private Object dequeue() {
        Object e = items[takeIndex];
        if (++takeIndex == count)
            takeIndex = 0;
        count--;
        return e;
    }
}

