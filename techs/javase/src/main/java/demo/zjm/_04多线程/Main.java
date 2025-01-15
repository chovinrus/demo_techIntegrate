package demo.zjm._04多线程;

/**
 * @author 管理员
 * @version 1.0
 */
public class Main {

    private static int a = 0;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (a == 0) {
                synchronized (Main.class) {
                    try {
                        System.out.println("sleeping in thread..");
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("in ..");
                }
                System.out.println("out of lock..");
            }
            System.out.println("线程结束！");
        }).start();

        System.out.println("sleeping in main..");
        Thread.sleep(1000);
        synchronized (Main.class) {
            a = 1;
            System.out.println("正在修改a的值...");
        }

    }
}
