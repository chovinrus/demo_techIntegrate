package demo.zjm._10新特性._04构造器引用和数组引用;

interface Consumer {
    //注意返回值应当为引用的构造器所属的类
    //没有返回值的话试想我们要这破构造器引用有何用
    Class getClass(String str);
}

interface Consumer0 {
    //注意返回值应当为引用的数组
    Integer[] getArray(Integer num);
}

class Class {
    String str;

    public Class(String str) {
        this.str = str;
    }
}

public class Main {
    public static void main(String[] args) {
        //构造器引用
        //Consumer consumer = s -> new Class(s);
        Consumer consumer = Class::new;
        System.out.println(consumer.getClass(""));
        //新特性._04构造器引用和数组引用.Class@448139f0

        //数组引用
        //Consumer0 consumer0 = n -> new Integer[n];
        Consumer0 consumer0 = Integer[]::new;
        System.out.println(consumer0.getArray(3));
        //[Ljava.lang.Integer;@58372a00
    }
}
