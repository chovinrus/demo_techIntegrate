package demo.zjm._04多线程._02run方法;

public class Main {
    public static void main(String[] args) {
        new Thread() {
            public void run() {
                System.out.println("run ..");
                System.out.println(Thread.currentThread().getName());
            }
        }.run();
        //run ..
        //main

        new Thread() {
            public void run() {
                System.out.println("run ..");
                System.out.println(Thread.currentThread().getName());
            }
        }.start();
        //run ..
        //Thread-1s
    }
}
