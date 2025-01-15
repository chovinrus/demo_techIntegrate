package demo.zjm._04多线程._07守护线程;

public class Main {
    public static void main(String[] args) {
        new Thread() {
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        Thread thread = new Thread() {
            public void run() {
                Thread thread2 = new Thread() {
                    public void run() {
                        System.out.println(this.isDaemon());//true
                        while (true) {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            System.out.println("run in thread2 ..");
                        }
                    }
                };
                thread2.start();
                while (true) {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("run in thread1 ..");
                }
            }
        };
        //thread.setDaemon(true);
        thread.start();
        //true

    }
}


