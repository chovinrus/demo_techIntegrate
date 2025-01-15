package demo.zjm.代理模式._03动态代理;

import java.util.Collections;

public class InterfaceCommonAction{
    public void preFunction(){
        System.out.println("pre function..");
    }

    public void afterFuntion(){
        System.out.println("after function..");

    }
}
