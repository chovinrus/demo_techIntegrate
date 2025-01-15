package demo.zjm.代理模式._04动态代理_多个接口_多个方法;

import java.lang.reflect.Proxy;

public class Main {
//    public static Interface getProxyInstance(Interface aImplement){
//        InvocationHandlerImpl invocationHandler = new InvocationHandlerImpl(aImplement);
//        return (Interface) Proxy.newProxyInstance(aImplement.getClass().getClassLoader(),
//                aImplement.getClass().getInterfaces(), (InvocationHandler) invocationHandler);
//    }

    //上述代码还可以扩展到别的接口，以及，实现的接口可以怎样诶不止一个，故我们把Interface限制去掉,改成Object
    //这样我们就发现这段代码重用价值很高了
    public static Object getProxyInstance(Object principal){
        return Proxy.newProxyInstance(principal.getClass().getClassLoader(),
                principal.getClass().getInterfaces(), new InvocationHandlerImpl(principal));
    }

    public static void main(String[] args) {
        ((intf0)getProxyInstance(new impl0())).fun0();
        ((intf1)getProxyInstance(new impl0())).fun2();
        //pre function..
        //fun0..
        //after function..
        //pre function..
        //fun2..
        //after function..
    }
}
