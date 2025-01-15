package demo.zjm._04多线程._09线程安全问题;

public class Main {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            int ticket = 100;

            @Override
            public void run() {
                while (ticket > 0)
                    System.out.println(Thread.currentThread().getName() + " sell: " + ticket--);
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
