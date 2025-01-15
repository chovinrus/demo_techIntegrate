package demo.zjm._02面向对象._11默认方法和接口冲突;

public class Impl implements intf1, intf2 {

    @Override
    public void fun() {
        intf1.super.fun();//这里的用法是个问题，待解决
    }
}
