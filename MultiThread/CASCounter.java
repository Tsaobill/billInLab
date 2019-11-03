package MultiThread;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-25 23:15
 **/
public class CASCounter {
    private static Unsafe unsafe;
    private static long valueOffset;
    static {
        try{
            Field field = Unsafe.class.getDeclaredField ("theUnsafe");
            field.setAccessible (true);
            unsafe =(Unsafe)field.get(Unsafe.class);
        }catch (Exception e){
            e.printStackTrace ();
        }
        try{
            valueOffset =unsafe.objectFieldOffset (CASCounter.class.getDeclaredField ("value"));
        }catch (NoSuchFieldException e){
            e.printStackTrace ();
        }
    }

    private volatile int value;
    public CASCounter(){value = 0;}
    public CASCounter(int value){this.value= value;}

    public int getValue() {
        return value;
    }

    public int increment(int incrNum) { // 线程安全
        while (true){
            int oldVal = value;
            int newVal = oldVal+incrNum;
            if(unsafe.compareAndSwapInt (this,valueOffset,oldVal,newVal)){
                return newVal;
            }
        }
    }

    public int increment(int incrNum,boolean b) { // 非线程安全
        value += incrNum;
        return value;
    }


}
