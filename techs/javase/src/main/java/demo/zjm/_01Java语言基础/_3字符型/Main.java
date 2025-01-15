package demo.zjm._01Java语言基础._3字符型;

public class Main {
    public static void main(String[] args) {
        //字符类型3种表现形式
        char c1 = '2';
        char c2 = '\'';
        char c3 = '\u6238';

        //整型常量还能转字符型，原因就是字符型的本质是存储的整型常量
        char c = 97;
        System.out.println(c);
        int num = 97;

        //给报错了
        //Required type:
        //char
        //Provided:
        //int
        //transient关键字.c = num;
    }
}
