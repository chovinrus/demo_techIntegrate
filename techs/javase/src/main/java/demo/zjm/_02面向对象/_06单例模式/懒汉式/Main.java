package demo.zjm._02面向对象._06单例模式.懒汉式;

public class Main {
    private static Main main;

    private Main() {
    }

    public static Main getMain() {
        if (main == null) {
            main = new Main();//懒就懒在用的时候才创建对象
        }
        return main;
    }
}
