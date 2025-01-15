package demo.zjm._08反射._13反射获取实现的接口;

import java.util.Arrays;

public class Main implements Interface<String>, SubItfc {
    public static void main(String[] args) {
        //public Class<?>[] getInterfaces()
        System.out.println(Arrays.asList(Main.class.getInterfaces()));
        //public Type[] getGenericInterfaces()
        System.out.println(Arrays.asList(Main.class.getGenericInterfaces()));
        //[interface 反射._13反射获取实现的接口.Interface, interface 反射._13反射获取实现的接口.SubItfc]
        //[反射._13反射获取实现的接口.Interface<java.lang.String>, interface 反射._13反射获取实现的接口.SubItfc]
    }
}
