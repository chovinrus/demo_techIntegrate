package demo.zjm.代理模式._03动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class InvocationHandlerImpl implements InvocationHandler {
    private Object proxy;

    public InvocationHandlerImpl(Object impl) {
        this.proxy = impl;
    }

    @Override
    //这里我们注意invoke里的这个proxy没啥卵用，根本原因是没有设计成让这个InvocationHandler接口
    //的invoke方法的proxy形参与外部直接交互，这样一来相当于必须让我们手写这个proxy写在handler的实现类里
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        InterfaceCommonAction interfaceCommonAction = new InterfaceCommonAction();
        interfaceCommonAction.preFunction();
        proxy = this.proxy;
        //关键的步骤就是让proxy的method和principal的method跑相同的参数
        Object invokeResult = method.invoke(proxy, args);
        interfaceCommonAction.afterFuntion();
        return invokeResult;
    }
}
