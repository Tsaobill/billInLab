/**
 * @author
 * @create 2019-04-02 10:50
 **/

package MultiThread.ThreadPoolDemo;

import java.util.concurrent.*;

public class CreateThreadDemo {
    public static void main(String[] args) {

        Runnable r= new Runnable() {
            @Override
            public void run() {
                System.out.println("线程："+Thread.currentThread().getName()+"正在运行");
            }
        };
        //r.run();

        ThreadExtend tt = new ThreadExtend();
        tt.start();
        ThreadRunnable tr = new ThreadRunnable();
        tr.run();
        //Thread ttr = new Thread(new ThreadRunnable());
        //ttr.start();

        ExecutorService es= Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程池"+Thread.currentThread().getName());
                }
            };
            es.execute(runnable);
        }
        es.shutdown();
    }
}
class ThreadExtend extends  Thread{
    @Override
    public void run() {
        System.out.println("我是通过集成Thread类创建的线程");
    }
    @Override
    public void start(){
        run();
    }
}
class  ThreadRunnable implements Runnable{
    @Override
    public  void run(){
        System.out.println("我是实现Runnable接口创建的线程");
    }
}
