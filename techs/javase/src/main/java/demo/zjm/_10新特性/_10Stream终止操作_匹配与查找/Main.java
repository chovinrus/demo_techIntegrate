package demo.zjm._10新特性._10Stream终止操作_匹配与查找;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //检查是否匹配所有元素
        //检查是否有匹配的元素
        //检查是否全部不匹配
        System.out.println(Stream.of(1, 2, 3).allMatch(t -> t > 0));
        System.out.println(Stream.of(1, 2, 3).anyMatch(t -> t < 0));
        System.out.println(Stream.of(1, 2, 3).noneMatch(t -> t < 0));
        //返回流的第一个元素
        //返回流的任意元素
        System.out.println(Stream.of(1, 2, 3).findFirst());
        System.out.println(Stream.of(1, 2, 3).findAny());

        //参数是比较器，返回最大或最小的元素
        System.out.println(Stream.of(1, 2, 3).max((n1, n2) -> n1 - n2));
        System.out.println(Stream.of(1, 2, 3).min((n1, n2) -> n1 - n2));

        //返回元素的个数
        System.out.println(Stream.of(1, 2, 3).count());
    }
}
