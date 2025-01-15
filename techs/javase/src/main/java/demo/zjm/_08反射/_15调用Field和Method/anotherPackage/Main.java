package demo.zjm._08反射._15调用Field和Method.anotherPackage;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException, InstantiationException {
        //Method的invoke
        demo.zjm._08反射._15调用Field和Method.Main main = new demo.zjm._08反射._15调用Field和Method.Main();
        Method method1 = demo.zjm._08反射._15调用Field和Method.Main.class.getMethod("method1", String.class);
        Method method2 = demo.zjm._08反射._15调用Field和Method.Main.class.getDeclaredMethod("method2", Integer.class);
        method2.setAccessible(true);//设置为true等于禁用访问安全检查
        System.out.println(method1.invoke(main, ""));   //0
        System.out.println(method2.invoke(main, 1));    //噜噜噜
        //静态方法的调用
        Method method = demo.zjm._08反射._15调用Field和Method.Main.class.getMethod("getaDouble");
        System.out.println(method.invoke(null));//此时invoke方法第一个参数随便写，语法检查通过就行。
        //3.141592653589793

        //Field的set和get
        Field num = main.getClass().getDeclaredField("num");
        Field str = main.getClass().getField("str");
        num.setAccessible(true);//注释的话会发现即使是get方法也要有访问权限
        System.out.println(num.get(main));  //null
        System.out.println(str.get(main));  //null
        str.set(main, "略略略");
        num.set(main, 3);
        System.out.println(num.get(main));  //3
        System.out.println(str.get(main));  //略略略
        //静态属性的调用
        Field field = main.getClass().getField("aDouble");
        System.out.println(field.get(null));//这里同样是因为静态，参数直接乱写
        //6.283185307179586
        field.set(null, 3.14);
        System.out.println(field.get(null));
        //3.14

        //调用构造器,发现同样要设置权限检查关闭才能调用
        Constructor<? extends demo.zjm._08反射._15调用Field和Method.Main> declaredConstructor = main.getClass().getDeclaredConstructor(Integer.class, String.class);
        declaredConstructor.setAccessible(true);
        demo.zjm._08反射._15调用Field和Method.Main main1 = declaredConstructor.newInstance(250, "噜噜噜");
        System.out.println(main1);
        //a.Main{num=250, str='噜噜噜'}
    }
}
