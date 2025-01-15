package demo.zjm._04多线程._13线程死锁;

class A {
    static synchronized void getLock() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        B.getLock();
    }
}

class B {
    static synchronized void getLock() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        A.getLock();
    }
}

class runnable implements Runnable {
    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("thread0")) {
            System.out.println("thread0");
            A.getLock();
            System.out.println("end");
        } else if (Thread.currentThread().getName().equals("thread1")) {
            System.out.println("thread1");
            B.getLock();
            System.out.println("end");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        runnable runnable = new runnable();
        Thread thread0 = new Thread(runnable, "thread0");
        Thread thread1 = new Thread(runnable, "thread1");
        thread0.start();
        thread1.start();
    }
}
