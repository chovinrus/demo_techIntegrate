package demo.zjm._04多线程._03start只能执行一次;

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            public void run() {
                System.out.println("run ..");
            }
        };
        thread.start();
        thread.start();
        //run ..
    }
}
