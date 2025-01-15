package demo.zjm.代理模式._04动态代理_多个接口_多个方法;

public class InterfaceCommonAction {
    public void preFunction(){
        System.out.println("pre function..");
    }

    public void afterFuntion(){
        System.out.println("after function..");
    }
}
