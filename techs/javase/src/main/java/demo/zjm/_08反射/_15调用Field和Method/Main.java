package demo.zjm._08反射._15调用Field和Method;

public class Main {
    //静态变量与静态方法
    public static Double aDouble = Math.PI * 2;
    public String str;
    //默认修饰符的话在不同包环境下没有访问权限
    Integer num;

    Main(Integer num, String str) {
        this.num = num;
        this.str = str;
    }

    public Main() {
    }

    public static Double getaDouble() {
        return Math.PI;
    }

    String method2(Integer integer) {
        return "略略略";
    }

    public Integer method1(String str) {
        return 0;
    }

    @Override
    public String toString() {
        return "a.Main{" +
                "num=" + num +
                ", str='" + str + '\'' +
                '}';
    }
}
