package demo.zjm._01Java语言基础._08复合赋值运算符的自动类型转换;

public class Main {
    public static void main(String[] args) {
        byte b = 0;
        b += 2;//按理返回应该是int型，这里要强转，然而并不用，这里可以自动转换
        //b = b +2;
        b = ++b;//这里也是常用的一个情形
    }
}
