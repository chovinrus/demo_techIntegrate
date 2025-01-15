package demo.zjm._02面向对象._09代理模式;

//代理类
public class proxy {
    Pincipal pincipal;

    public proxy(Pincipal pincipal) {
        this.pincipal = pincipal;
    }

    public void fun() {
        System.out.println("pre fun..");
        pincipal.fun();
        System.out.println("after fun..");
    }
}
