package com;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-08-31 19:12
 **/
public class PCModel {
    static int size = 0;
    static int Max = 10;

    public static void main(String[] args) {
        String s = "1212";
        for (int i = 0; i < 5; i++) {
            new Comsumer (s).start ();
            new Producer (s).start ();
        }
    }

    static class Comsumer extends Thread {
        Object lock;

        public Comsumer(Object o) {
            this.lock = o;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    synchronized (lock) {
                        while (size == 0) {
                            lock.wait ();
                        }
                        size--;
                        System.out.println (size);
                        lock.notifyAll ();
                    }
                } catch (Exception e) {
                    e.printStackTrace ();
                }
            }
        }
    }

    static class Producer extends Thread {
        Object lock;

        public Producer(Object o) {
            this.lock = o;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    synchronized (lock) {
                        while (size == Max) {
                            lock.wait ();
                        }
                        size++;
                        System.out.println (size);
                        lock.notifyAll ();
                    }
                } catch (Exception e) {
                    e.printStackTrace ();
                }

            }
        }
    }
}
