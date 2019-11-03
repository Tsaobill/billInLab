

/**
 * 栈的实现
 * 1.利用链表
 * 2.利用数组
 * 下面使用数组实现的
 *
 * @version 1.0
 * @created by bill
 * @on 2018-10-16 上午10:33
 **/
public class Stack<T> {
    private T[] theArray;
    private int topOfStack = -1;

    public Stack(int n) {
        theArray = (T[]) new Object[n];
    }

    public T pop() {
        if (topOfStack >= 0) {
            T top = theArray[topOfStack];
            topOfStack--;
            return top;
        } else {
            System.out.println ("下溢");
            return null;
        }
    }


    public void push(T x) {
        if (topOfStack < theArray.length - 2) {
            topOfStack++;
            theArray[topOfStack] = x;
        } else {
            System.out.println ("栈上溢");
        }
    }

    public boolean isEmpty() {
        return topOfStack == -1;
    }

}
