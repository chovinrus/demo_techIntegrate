package demo.zjm._02面向对象._16匿名内部类;

interface intf {
    public void fun();
}

class Base {
    public void fun() {
        System.out.println("base fun ..");
    }
}

public class Main {
    public static void main(String[] args) {
        new intf() {
            @Override
            public void fun() {
                System.out.println("fun ..");
            }
        }.fun();
        //fun ..

        new Base() {
            @Override
            public void fun() {
                System.out.println("sub fun ..");
            }
        }.fun();
    }
}
