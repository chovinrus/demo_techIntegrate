package demo.zjm._10新特性._01Lambda表达式;

public class Main {
    static void returnReceive(Interface2 interface2) {
        System.out.println(interface2.getClass());
    }

    public static void main(String[] args) {
        //这里类型推断省略形参类型
        //方法体仅有一句，直接省略花括号
        Interface<Integer> impl = (n1, n2) -> System.out.println(n1 + n2);
        impl.add(1, 2);

        //形参只有一个且能推断之，省略形参列表括号
        Interface1<Integer> impl1 = n1 -> System.out.println(n1);
        impl1.show(250);

        //作为参数类型的类型推断
        returnReceive(n -> {
        });
        //class 新特性.Lambda表达式.a.Main$$Lambda$3/2093631819
    }

    @FunctionalInterface
    interface Interface<T> {
        void add(T n1, T n2);

    }

    interface Interface1<T> {
        void show(T n1);
    }

    interface Interface2<T> {
        void ret(T n1);
    }
}
