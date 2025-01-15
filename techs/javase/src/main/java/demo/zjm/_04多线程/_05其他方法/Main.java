package demo.zjm._04多线程._05其他方法;

public class Main {
    public static void main(String[] args) {
        //设置线程name
        Thread thread = new Thread() {
        };
        thread.setName("thread0");
        System.out.println(thread.getName());

        //构造器设置name
        System.out.println(new Thread("thread1").getName());

        //toString方法的内容：name 优先级 创建的线程
        System.out.println(new Thread("thread2"));
        System.out.println(Thread.currentThread());

        //stop()方法
        //Thread.currentThread().stop();
        //System.out.println("---");
        //Process finished with exit code 1

        //isAlive()
        thread.start();
        thread.stop();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread.isAlive());
        //false

    }
}
