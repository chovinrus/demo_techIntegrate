package demo.zjm._10新特性._05获取Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //1.从集合直接用stream()方法获取
        ArrayList<Integer> integers = new ArrayList<>();
        Stream<Integer> stream = integers.stream();
        System.out.println(stream);
        //2.获取并行流
        Stream<Integer> integerStream = integers.parallelStream();
        System.out.println(integerStream);
        //3.从数组获取流
        Integer[] array = new Integer[3];
        System.out.println(Arrays.stream(array));
        //4.从静态方法获取
        System.out.println(Stream.of(array));//注意of()方法获得的数据，元素为括号中的类型
        Stream.of(1, 2, 3, 4).forEach(System.out::println);
        //java.util.stream.ReferencePipeline$Head@14ae5a5
        //java.util.stream.ReferencePipeline$Head@7f31245a
        //java.util.stream.ReferencePipeline$Head@6d6f6e28
        //java.util.stream.ReferencePipeline$Head@135fbaa4
        //1
        //2
        //3
        //4
    }
}
