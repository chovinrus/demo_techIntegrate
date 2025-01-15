package demo.zjm._04多线程._15线程通信;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {

            int num = 0;
            Lock lock = new ReentrantLock();

            @Override
            public void run() {
                while (true) {
                    synchronized (this) {
                        notify();
                        if (num < 100) {
                            System.out.println(Thread.currentThread().getName() + " : " + num++);
                        }
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        Thread thread0 = new Thread(runnable, "thread0");
        Thread thread1 = new Thread(runnable, "thread1");
        thread0.start();
        thread1.start();
    }
}
