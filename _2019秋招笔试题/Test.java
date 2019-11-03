package _2019秋招笔试题;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-07-28 13:15
 **/
public class Test extends Fa {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newScheduledThreadPool (2);
        //ThreadPoolExecutor executor1 = new
        String[] a = new String[]{"1","2"};
        List list = Arrays.asList (a);
        list.add(3);
        System.out.println (list.toString ());
    }

    public Test() {
        //super ();
        this.a = 123;
    }
}

class Fa {
    String name = "代码";
    int a;

    public Fa() {
        System.out.println ("aaaa");
        //this.name = "构造";
    }
}
