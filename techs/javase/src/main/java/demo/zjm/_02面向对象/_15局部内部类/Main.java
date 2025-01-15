package demo.zjm._02面向对象._15局部内部类;

public class Main {

    public static void main(String[] args) {
        System.out.println(new Main().fun());
        System.out.println(new Main().fun().getClass());
        //_02面向对象._15局部内部类._01对象的返回.a.Main$1Inner@6d6f6e28
        //class _02面向对象._15局部内部类._01对象的返回.a.Main$1Inner
    }

    Main fun() {
        class Inner extends Main {

        }
        return new Inner();
    }
}
