package demo.zjm._08反射._06用反射创建对象;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {

    String field1 = null;
    int num;

    public Main() {
    }

    public Main(String field1, int num) {
        this.field1 = field1;
        this.num = num;
    }

    Main(String field1) {
        this.field1 = field1;
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //这里注意有两个要求
        //1.必须有空参构造器
        //2.必须有相应的访问权限
        Main main = Main.class.newInstance();
        System.out.println(main);//a.Main{field1='null', num=0}

        //我们试一下带参数的构造器
        //a.Main main1 = a.Main.class.newInstance("field1 content",100);
        //发现不行
        //正确的做法是搞一个构造器类的实例
        //注意这个方法的参数是类对象,返回值是public构造器
        /**
         * Returns a {@code Constructor} object that reflects the specified
         * public constructor of the class represented by this {@code Class}
         * object
         */
        Constructor<Main> constructor =
                Main.class.getConstructor(String.class, int.class);
        Main main1 = constructor.newInstance("", 1);
        System.out.println(main1);//a.Main{field1='', num=1}

        //试一下getDeclaredConstructor()和非public的，发现可以
        Constructor<Main> declaredConstructor = Main.class.getDeclaredConstructor(String.class);
        System.out.println(declaredConstructor.newInstance("啦啦啦"));//a.Main{field1='啦啦啦', num=0}

        //我们也可以对获得的构造器进行进一步获取相关信息
        System.out.println(constructor.getParameters());
        System.out.println(constructor.getModifiers());
        System.out.println(constructor.getName());
        //[Ljava.lang.reflect.Parameter;@1b6d3586
        //1
        //反射._06用反射创建对象.a.Main
    }

    @Override
    public String toString() {
        return "a.Main{" +
                "field1='" + field1 + '\'' +
                ", num=" + num +
                '}';
    }
}
