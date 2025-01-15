package demo.zjm._05常用类._11Math.Random;

public class Main {
    public static void main(String[] args) {
        //获取 a-b 的整数
        int a = 2;
        int b = 7;
        System.out.println((int) (a + Math.random() * (b - a + 1)));
    }
}
