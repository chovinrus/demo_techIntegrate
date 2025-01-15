package demo.zjm._04多线程._10同步代码块;

public class Main {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            int ticket = 100;

            @Override
            public void run() {
                while (true) {
                    //注意这里应该将轮询的逻辑写到循环内部的if语句中
                    //否则阻塞的代码就是整个循环
                    synchronized (this) {
                        if (ticket > 0) {
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            System.out.println(Thread.currentThread().getName() + " sell: " + ticket--);
                        } else break;
                    }
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
