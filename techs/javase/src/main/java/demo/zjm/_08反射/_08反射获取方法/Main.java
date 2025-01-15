package demo.zjm._08反射._08反射获取方法;

import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
    @SuppressWarnings("")
    @Deprecated
    @annotation
    //注意反射获取注解，注解的生命周期必须是RunTime才能获取成功
    private int fun(Integer num) throws Exception {
        return 0;
    }

    @Test
    public void test() throws NoSuchMethodException {
        //获取父类及当前类的声明为public的方法
        System.out.println(Arrays.asList(Main.class.getMethods()));
        //[public void 反射._08反射获取方法.a.Main.test() throws java.lang.NoSuchMethodException, public final void java.lang.Object.wait() throws java.lang.InterruptedException, public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException, public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException, public boolean java.lang.Object.equals(java.lang.Object), public java.lang.String java.lang.Object.toString(), public native int java.lang.Object.hashCode(), public final native java.lang.Class java.lang.Object.getClass(), public final native void java.lang.Object.notify(), public final native void java.lang.Object.notifyAll()]
        //获取当前类声明的所有方法
        for (Method declaredMethod : Main.class.getDeclaredMethods()) {
            System.out.println(declaredMethod);
            //public void 反射._08反射获取方法.a.Main.test()
            //private void 反射._08反射获取方法.a.Main.fun()
        }
        System.out.println(Main.class.getDeclaredMethod("fun", Integer.class).getName());
        System.out.println(Main.class.getDeclaredMethod("fun", Integer.class).getReturnType());
        System.out.println(Arrays.asList(Main.class.getDeclaredMethod("fun", Integer.class).getParameterTypes()));
        System.out.println(Modifier.toString(Main.class.getDeclaredMethod("fun", Integer.class).getModifiers()));
        System.out.println(Arrays.asList(Main.class.getDeclaredMethod("fun", Integer.class).getExceptionTypes()));
        System.out.println(Arrays.toString(Main.class.getDeclaredMethod("fun", Integer.class).getAnnotations()));
        //fun
        //int
        //[class java.lang.Integer]
        //private
        //[class java.lang.Exception]
        //[@反射._08反射获取方法.annotation()]
    }
}
