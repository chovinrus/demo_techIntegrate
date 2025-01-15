package demo.zjm._10新特性._06创建无限流;

import java.util.stream.Stream;

public class Main {
    static String UnaryOperator(String string) {
        return "+".equals(string) ? "-" : "+";
    }

    public static void main(String[] args) {

        //public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
        //UnaryOperator是一个参数接口，它继承自Function，接收一个参数，返回和参数同样类型的结果
        //第一个参数为起始值，第二个参数为UnaryOperator接口实例
        Stream.iterate(1, t -> ++t).limit(10).forEach(System.out::println);
        Stream.iterate("+", Main::UnaryOperator).limit(10).forEach(System.out::println);

        //public static<T> Stream<T> generate(Supplier<T> s)
        //参数是空参有返回的方法引用
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }
}
