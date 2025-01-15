package demo.zjm._01_单例模式;

import java.io.*;
import java.lang.reflect.Constructor;

// 饿汉式，不能做到延迟加载
class Singleton0 {
    private static Singleton0 singleton = new Singleton0();

    private Singleton0() {
    }

    public static Singleton0 getSingleton() {
        return singleton;
    }
}

// 懒汉式，不能做到线程安全
class Singleton1 {
    private static Singleton1 singleton;

    private Singleton1() {

    }

    public static Singleton1 getSingleton() {
        if (null == singleton) {
            singleton = new Singleton1();
        }
        return singleton;
    }
}

//线程方法实现懒汉式，但是加锁的时机没把握，创建好之后仍然是临界的，并发度低
class Singleton2 {
    private static Singleton2 singleton;

    private Singleton2() {
    }

    public static synchronized Singleton2 getSingleton() {
        if (null == singleton) {
            singleton = new Singleton2();
        }
        return singleton;
    }
}

//双重检验，外层检验提高并发度，内层保证线程安全
class Singleton3 {
    //一定不要忘记添加volatile关键字
    private static volatile Singleton3 singleton;

    private Singleton3() {
    }

    public static Singleton3 getSingleton() {
        if (null == singleton) {
            synchronized (Singleton3.class) {
                if (null == singleton) {
                    singleton = new Singleton3();
                }
            }
        }
        return singleton;
    }
}

//静态内部类实现，同样能既满足按需加载，又满足线程安全
class Singleton4 {

    private Singleton4() {

    }

    static class innerClass {
        private static Singleton4 singleton = new Singleton4();
    }

    static Singleton4 getSingleton() {
        return innerClass.singleton;
    }
}

//反射对单例的破坏
//如果使用的是双重校验锁，可以考虑在在构造器中添加判断逻辑
class Singleton5 {
    private static Singleton5 singleton;

    public static Singleton5 getSingleton() throws Exception {
        if (null == singleton) {
            synchronized (Singleton5.class) {
                if (null == singleton) {
                    singleton = new Singleton5();
                }
            }
        }
        return singleton;
    }

    private Singleton5() throws Exception {
        if (null != singleton) {
            Exception e = new Exception("单例已存在");
            throw e;
        }
    }
}

//序列化对反射的破坏
class Singleton6 implements Serializable {
    private static Singleton6 singleton;

    public static Singleton6 getSingleton() throws Exception {
        if (null == singleton) {
            synchronized (Singleton6.class) {
                if (null == singleton) {
                    singleton = new Singleton6();
                }
            }
        }
        return singleton;
    }

    private Singleton6() throws Exception {
        if (null != singleton) {
            Exception e = new Exception("单例已存在");
            throw e;
        }
    }

    //对比观察，有无此方法时序列化对单例的破坏是否存在
    private Object readResolve() {
        return singleton;
    }
}

// 用枚举实现单例，同样能做到按需加载，而且不用考虑线程同步的问题，是天然的单例模式
// 能同时解决反射和序列化对单例的破坏
enum Singleton7 {
    SINGLETON;

    Singleton7() {
    }
}

// 主类
public class Main {
    public static void main(String[] args) throws Exception {
        //饿汉式、懒汉式
        //方法同步
        // 代码块双重校验
        // 静态代码块
        // 枚举

        //饿汉式
        System.out.println(Singleton0.getSingleton().hashCode() == Singleton0.getSingleton().hashCode());
        //懒汉式
        System.out.println(Singleton1.getSingleton().hashCode() == Singleton1.getSingleton().hashCode());
        //同步方法懒汉式
        System.out.println(Singleton2.getSingleton().hashCode() == Singleton2.getSingleton().hashCode());
        //双重检查懒汉式
        System.out.println(Singleton3.getSingleton().hashCode() == Singleton3.getSingleton().hashCode());
        //静态内部类懒汉式
        System.out.println(Singleton4.getSingleton().hashCode() == Singleton4.getSingleton().hashCode());

        System.out.println("——————————————————————————————————————————————————————————");

        // 双重校验锁下在构造器中防止单例破坏，方法是在构造器中添加判断逻辑
        Constructor<Singleton5> singleton5Constructor = Singleton5.class.getDeclaredConstructor();
        singleton5Constructor.setAccessible(true);
        //抛出异常
        //Singleton5 singleton5 = singleton5Constructor.newInstance();

        //序列化对单例的破坏，原理看下read操作的源码，解决办法是在单例的类中添加规定的方法readResolve以变更反序列化的策略
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("singleton.obj"));
        objectOutputStream.writeObject(Singleton6.getSingleton());
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singleton.obj"));
        Singleton6 singleton = (Singleton6) ois.readObject();
        System.out.println(Singleton6.getSingleton() == singleton);//false，添加readResolve后为true

        // 枚举只有一个常量的话就是单例模式
        System.out.println(Singleton7.SINGLETON == Singleton7.SINGLETON);//true
        // 反射是拿不到枚举的构造器的，枚举就是规定常量的，直接不给用反射实例化的机会
        // Constructor<Singleton7> declaredConstructor = Singleton7.class.getDeclaredConstructor();
        // 序列化对单例同样没有影响，序列化的策略是序列化常量名，反序列化的时候去查找常量
        ObjectOutputStream oos_ = new ObjectOutputStream(new FileOutputStream("singleton7.obj"));
        oos_.writeObject(Singleton7.SINGLETON);
        ObjectInputStream ois_ = new ObjectInputStream(new FileInputStream("singleton7.obj"));
        Singleton7 singleton7_new = (Singleton7) ois_.readObject();
        System.out.println(Singleton7.SINGLETON == singleton7_new);//true

    }
}
