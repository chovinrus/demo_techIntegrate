package demo.zjm._01Java语言基础._4类型转换;

public class Main {
    public static void main(String[] args) {
        //低精度转高精度自动转换，高精度转低精度需要强转
        int x = 0;
        byte y = 1;
        x = y;
        //y = x;

        //byte、short、char本质上都是存储整型常量
        short x1 = Short.MAX_VALUE;
        byte x2 = Byte.MAX_VALUE;
        char x3 = Character.MAX_VALUE;

        //体会自动转换中char类型与byte、short之间的互换失败
        byte a = 97;
        //char transient关键字.c = a;
        char b = 'c';
        //byte d = b;
        short f = 97;
        //char g = f;
        char c4 = 97;
        //short s = c4;

        //char在和其他数据类型一起运算时，表现为int类型
        //byte、char、short之间可以进行运算，进行时先自动转换成int类型计算
        char c5 = 'a';
        short s1 = 1;
        byte b1 = 3;
        System.out.println(((Object) (c5 + s1 + b1)).getClass().getName()); //java.lang.Integer
        System.out.println(((Object) (c5 + b1)).getClass().getName()); //java.lang.Integer
        System.out.println(((Object) (c5 + s1)).getClass().getName()); //java.lang.Integer
        System.out.println(((Object) (s1 + b1)).getClass().getName()); //java.lang.Integer
    }
}
