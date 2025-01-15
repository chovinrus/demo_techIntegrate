package demo.zjm._05常用类._02String的常用方法;

import java.nio.charset.Charset;

public class Main {
    public static void main(String[] args) {
        //大小写转换
        System.out.println("AbCDe".toUpperCase());//ABCDE
        System.out.println("AbCDe".toLowerCase());//abcde

        //获取下标字符
        System.out.println("asvsd".charAt(0));//a

        //子串
        System.out.println("abjkab".substring(1, 3));//bj

        //去掉前后空格
        System.out.println("  dw ".trim());//dw

        //忽略大小写判等
        System.out.println("s".equalsIgnoreCase("S"));///true

        //比较返回第一个不等的字符之间的字符整数值的差
        System.out.println("abc".compareTo("b"));//-1

        //连接字符串
        System.out.println("abc".concat("d"));//abcd

        //判断包含
        System.out.println("abcd".contains("bc"));//true
        //判断是否以之开头
        System.out.println("acid".startsWith("ac"));//true
        System.out.println("acid".endsWith("id"));//true
        //判断开头的位置
        System.out.println("acid".startsWith("ac", 0));//true

        //获取字符下标
        System.out.println("abcd".indexOf('c'));//2
        System.out.println("abcde".lastIndexOf('c'));//2
        //获得子串
        System.out.println("abcd".substring(1, 2));//b

        //与字符数组转换
        String str = new String(new char[]{'1', '2', '3'}, 0, 2);
        char[] chars = str.toCharArray();
        str.getChars(0, 1, chars, 1);
        System.out.println(chars);//11

        //与字节流转换
        byte[] bytes = str.getBytes(Charset.defaultCharset());
        String s = new String(bytes);
    }
}
