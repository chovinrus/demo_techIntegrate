package demo.zjm.代理模式._02静态代理;

public class Main {
    public static void main(String[] args) {
        //声明一个实现类实例
        Interface principal = new Implement();
        //声明一个代理类实例
        ProxyInterface proxy = new ProxyInterface(principal);
        //通过调用代理类的实现方法间接调用实现类的实现方法
        proxy.function();
        //preFuntioning ..
        //One Implement's funtioning ..
        //afterFuntioning ..
    }
}
