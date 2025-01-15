package demo.zjm._04多线程._14Lock实现线程同步;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            int ticket = 100;
            //可以设置为公平锁
            Lock lock = new ReentrantLock(true);

            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    if (ticket > 0) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + " sell: " + ticket--);
                    }
                    lock.unlock();
                }
            }
        };
        Thread windows1 = new Thread(runnable, "windows1");
        Thread windows2 = new Thread(runnable, "windows2");
        Thread windows3 = new Thread(runnable, "windows3");
        windows1.start();
        windows2.start();
        windows3.start();
    }
}
