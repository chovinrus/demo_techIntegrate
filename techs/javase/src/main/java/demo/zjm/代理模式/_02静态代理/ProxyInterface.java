package demo.zjm.代理模式._02静态代理;

//代理类定义
//我们用代理类去使用实现类，做法就是
// 1，在代理类中声明私有的实现类的实例，其实也可以是多个啦
// 2，再代理类中实现代理方法，应当是和实现类的实现方法同名
// 3，这样我们就可以用代理类的实现方法去调用不同实现类的实现方法，并且能在实现类的实现之外，添加额外的通用的实现内容
public class ProxyInterface implements Interface {
    private Interface proxy;

    public ProxyInterface(Interface aImplement) {
        this.proxy = aImplement;
    }

    @Override
    public void function() {
        System.out.println("preFuntioning ..");
        proxy.function();
        System.out.println("afterFuntioning ..");
    }
}
