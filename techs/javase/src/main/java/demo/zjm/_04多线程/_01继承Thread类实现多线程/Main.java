package demo.zjm._04多线程._01继承Thread类实现多线程;

public class Main {
    public static void main(String[] args) {
        new Thread() {
            public void run() {
                System.out.println("run ..");
            }
        }.start();
        //run ..
        //IllegalThreadStateException
    }
}
