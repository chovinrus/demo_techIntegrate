package demo.zjm._02面向对象._14static关键字;

public class Main {

    //两个事
    //实例成员可以访问静态成员
    //静态成员访问额不了实例属性

    static int num = 1;
    int num1 = 250;
    //static int num2 = num1;

    static void fun1() {
        System.out.println(num);
        //System.out.println(num1);
        //fun0();
    }

    public static void main(String[] args) {
        //new Inner0();
    }

    void fun0() {
        System.out.println(num);
        System.out.println(num1);
        fun1();
    }

    static class Inner1 {
        //int num2 = num1;
        int num = Main.num;
    }

    class Inner0 {
        int num = Main.num;        int num1 = this.num1;

    }
}
