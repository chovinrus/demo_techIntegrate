package demo.zjm._08反射._12获取父类和带泛型的父类;

import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;

public class Main<Integer> extends Base<String> {
    @Test
    public void test() {
        //public Class<? Super T> getSuperclass()	获取父类
        System.out.println(Main.class.getSuperclass());
        //class 反射._12获取父类和带泛型的父类.Base

        //public Type getGenericSuperclass()    获取带泛型的父类
        System.out.println(Main.class.getGenericSuperclass());
        //反射._12获取父类和带泛型的父类.Base<java.lang.String>
        //进一步获取最后的实际的带参类型的参数
        System.out.println(Arrays.asList(((ParameterizedType) Main.class.getGenericSuperclass()).getActualTypeArguments()));
        //[class java.lang.String]
    }
}
