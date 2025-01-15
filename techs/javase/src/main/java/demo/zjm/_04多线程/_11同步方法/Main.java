package demo.zjm._04多线程._11同步方法;

class Window extends Thread {
    static int ticket = 100;

    public Window(String name) {
        super(name);
    }

    public static synchronized void sell() {
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " sell:" + ticket--);
        }
    }

    @Override
    public void run() {
        while (true) {
            sell();
            if (ticket == 0)
                break;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Window window1 = new Window("window1");
        Window window2 = new Window("window2");
        Window window3 = new Window("window3");
        window1.start();
        window2.start();
        window3.start();
    }
}
