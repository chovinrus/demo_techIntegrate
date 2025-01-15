package demo.zjm._04多线程._03yield方法;

public class Main {
    public static void main(String[] args) {
        Thread thread0 = new Thread() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i > 50)
                        Thread.yield();
                    if (i < 50) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("thread0 run in " + i);
                }
            }
        };

        Thread thread1 = new Thread() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i < 50) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("thread1 run in " + i);
                }
            }
        };
        thread0.start();
        thread1.start();
    }
}
