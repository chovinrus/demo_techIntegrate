package demo.zjm._02面向对象._13成员内部类._02外部类访问内部类成员;

public class Main {
    static int num1 = Inner1.num;
    int num = new Inner().num;

    static class Inner1 {
        static int num;
    }

    class Inner {
        int num = 3;
    }
}
