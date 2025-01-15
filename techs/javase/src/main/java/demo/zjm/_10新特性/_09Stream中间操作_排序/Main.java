package demo.zjm._10新特性._09Stream中间操作_排序;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //自然排序
        Stream.of(3, 2, 1).sorted().forEach(System.out::println);
        //1
        //2
        //3

        //按照比较器排序
        Stream.of(1, 2, 3).sorted((n1, n2) -> n2 - n1).forEach(System.out::println);
        //3
        //2
        //1
    }
}
