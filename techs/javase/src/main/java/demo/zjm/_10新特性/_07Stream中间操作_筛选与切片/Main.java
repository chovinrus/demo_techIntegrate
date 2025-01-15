package demo.zjm._10新特性._07Stream中间操作_筛选与切片;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //Stream<T> filter(Predicate<? super T> predicate);
        //对流中的数据筛选过滤，传入一个断言式方法，保留值为真的结果
        Stream.of(1, 2, 3, 4).filter(t -> (t > 2)).forEach(System.out::println);
        new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4)).stream().filter(t -> t > 1).forEach(System.out::println);

        //Stream<T> distinct();
        //对流中的数据进行去重
        Stream.of(1, 2, 3, 1, 2, 3, 1, 4, 4, 5, 3, 4).distinct().forEach(System.out::println);

        //Stream<T> limit(long maxSize);
        //流中数据保留至最多maxSize个
        Stream.of(1, 2, 3, 4, 5, 6, 7).limit(4).forEach(System.out::println);

        //Stream<T> skip(long n);
        //流中数据跳过n个，若元素个数不足n，则流的数据为空
        Stream.of(1, 2, 3, 4, 5, 6, 7).skip(4).forEach(System.out::println);
    }
}
