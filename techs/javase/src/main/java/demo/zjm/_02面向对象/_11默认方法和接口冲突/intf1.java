package demo.zjm._02面向对象._11默认方法和接口冲突;

public interface intf1 {
    default void fun() {
        System.out.println("default funning");
    }
}
