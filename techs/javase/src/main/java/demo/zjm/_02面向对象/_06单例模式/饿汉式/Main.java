package demo.zjm._02面向对象._06单例模式.饿汉式;

public class Main {
    private static Main main = new Main();//饿就饿在没用的时候就已经创建了对象

    private Main() {
    }

    public static Main getMain() {
        return main;
    }
}
