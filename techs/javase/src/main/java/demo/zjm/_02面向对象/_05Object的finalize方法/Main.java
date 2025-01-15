package demo.zjm._02面向对象._05Object的finalize方法;

public class Main {
    public static void main(String[] args) {
        new Main();
        System.out.println("preGC");
        System.gc();
        System.out.println("afterGC");
        //preGC
        //afterGC
        //finalizing..
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalizing..");
    }
}
