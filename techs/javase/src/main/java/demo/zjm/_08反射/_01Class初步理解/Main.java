package demo.zjm._08反射._01Class初步理解;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class clazz = Class.forName("demo.zjm._08反射._01Class初步理解.AClass");
        Object o = clazz.newInstance();
        Field attr1 = clazz.getDeclaredField("name");
        attr1.set(o, "字段1");
        Object o1 = attr1.get(o);
        System.out.println(o1);//字段1
    }
}
