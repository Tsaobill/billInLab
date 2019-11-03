package com;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-08-31 19:29
 **/
public class LockImplPC {

    public static void main(String[] args) {
        Sto store = new Sto ();
        for (int i = 0; i < 100; i++) {
            new Pro (store).start ();
            new Cons (store).start ();
        }
    }


}

class Cons extends Thread {
    Sto s;

    public Cons(Sto s) {
        this.s = s;
    }

    @Override
    public void run() {
        s.consumer ();
    }
}

class Pro extends Thread {
    Sto s;

    public Pro(Sto s) {
        this.s = s;
    }

    @Override
    public void run() {
        s.produce ();
    }
}

class Sto {
    private ArrayBlockingQueue<Object> q = new ArrayBlockingQueue<> (5);


    public void produce() {
        try {
            q.put (new Object ());
            System.out.println ("+1 = " + q.size ());
        } catch (Exception e) {
            e.printStackTrace ();
        }
    }

    public void consumer() {
        try {
            q.take ();
            System.out.println ("-1 = " + q.size ());

        } catch (Exception e) {
            e.printStackTrace ();
        }
    }
}