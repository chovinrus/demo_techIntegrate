package demo.zjm._02面向对象._07成员变量初始化顺序;

public class Main {
    int field = 240;

    {
        System.out.println("pre block1 " + field);
        field = 250;
        System.out.println("after block1 " + field);
    }

    {
        System.out.println("pre block2 " + field);
        field = 260;
        System.out.println("after block2 " + field);
    }

    Main() {
        System.out.println("pre constructing " + field);
        this.field = 1000;
        System.out.println("after constructing " + field);
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.field);
        main.field = 1;
        System.out.println(main.field);
        //pre block1 240
        //after block1 250
        //pre block2 250
        //after block2 260
        //pre constructing 260
        //after constructing 1000
        //1000
        //1
    }
}
