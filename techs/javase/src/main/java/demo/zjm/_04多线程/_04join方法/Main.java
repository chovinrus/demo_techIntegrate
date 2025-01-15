package demo.zjm._04多线程._04join方法;

public class Main {
    public static void main(String[] args) {
        Thread thread0 = new Thread() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("thread0 run in " + i);
                }
            }
        };
        Thread thread1 = new Thread() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i == 30) {
                        try {
                            thread0.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("thread1 run in " + i);
                }
            }
        };
        thread1.start();
        thread0.start();
    }
}
