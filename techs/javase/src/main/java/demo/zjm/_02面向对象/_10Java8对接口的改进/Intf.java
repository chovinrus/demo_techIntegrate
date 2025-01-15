package demo.zjm._02面向对象._10Java8对接口的改进;

public interface Intf {
    static void staticFun() {
        System.out.println("static funning..");
    }

    default void defaultFun() {
        System.out.println("default funning..");
    }
}
