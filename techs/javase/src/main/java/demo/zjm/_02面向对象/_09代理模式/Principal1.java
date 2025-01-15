package demo.zjm._02面向对象._09代理模式;

//被代理类，通过接口实现被代理对象的多态
public class Principal1 implements Pincipal {

    @Override
    public void fun() {
        System.out.println("Principal1 is funning..");
    }
}
