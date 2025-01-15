package demo.zjm._02面向对象._12默认方法与继承方法冲突;

public interface Intf {
    default void fun() {
        System.out.println("default funning..");
    }
}
