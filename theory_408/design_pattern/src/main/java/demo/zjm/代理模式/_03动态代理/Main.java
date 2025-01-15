package demo.zjm.代理模式._03动态代理;

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
        Interface principal1 = new Implement1();
        Interface principal2 = new Implement2();
        System.out.println(((Interface)(getProxyInstance(principal1))));
        System.out.println(((Interface)(getProxyInstance(principal1))).function(250 * 1));
        //pre function..
        //Impl1's funtion ..
        //after function..
        //250
        System.out.println(((Interface)(getProxyInstance(principal2))).function(250 * 2));
        //pre function..
        //Impl2's funtion ..
        //after function..
        //500
        System.out.println(((Implement1)principal1).num);//250
        System.out.println(((Implement2)principal2).num);//500
    }
}
