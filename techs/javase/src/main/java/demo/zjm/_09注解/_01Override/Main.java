package demo.zjm._09注解._01Override;

interface Intfc {
    void method1();
}

class Base {
    void method0() {
        System.out.println("---");
    }
}

class Sub extends Base implements Intfc {

    @Override
    public void method0() {
        System.out.println("略略略");
    }

    @Override
    //检查实现的方法，若不对，报错就不是请求实现，
    //而是请求此处实现，红线在注解上，而不是在方法上
    public void method1() {
        System.out.println("啦啦啦");
    }
}

public class Main {
    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.method0();
        sub.method1();
        //略略略
        //啦啦啦
    }
}
