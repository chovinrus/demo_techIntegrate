package demo.zjm._04多线程._06线程优先级;

public class Main {
    public static void main(String[] args) {

        //public final static int MIN_PRIORITY = 1;
        //
        //public final static int NORM_PRIORITY = 5;
        //
        //public final static int MAX_PRIORITY = 10;

        Thread thread0 = new Thread() {
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread0 run ..");
            }
        };
        Thread thread1 = new Thread() {
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread1 run ..");
            }
        };
        thread0.setPriority(2);
        thread1.setPriority(3);
        thread0.start();
        thread1.start();

        Thread thread = new Thread() {
            public void run() {
                Thread thread2 = new Thread() {
                    public void run() {
                        System.out.println(this.isDaemon());//true
                    }
                };
                thread2.run();
            }
        };
        thread.setDaemon(true);
        thread.start();
    }
}
