package demo.zjm._04多线程._08Runnable实现多继承;

public class Main {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable runs ..");
            }
        }).start();
        //runnable runs ..
    }
}
