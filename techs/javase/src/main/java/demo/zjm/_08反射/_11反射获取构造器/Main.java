package demo.zjm._08反射._11反射获取构造器;

import java.util.Arrays;

public class Main {
    public Main() {
    }

    public Main(int num) {
    }

    private Main(String str) {
    }

    Main(char c) {

    }

    //这里严重注意一个问题
    //@Test注解修饰的方法所在的类只能有一个修饰符为public公有的无参的构造器
//    @Test
//    void test(){
//        System.out.println(Arrays.asList(a.Main.class.getConstructors()));
//    }

    public static void main(String[] args) {
        //getConstructors	获取当前类及父类声明为public 的构造器
        System.out.println(Arrays.asList(Main.class.getConstructors()));
        //getDeclaredConstructors    获取当前类声明的所有构造器
        System.out.println(Arrays.asList(Main.class.getDeclaredConstructors()));
    }
}
