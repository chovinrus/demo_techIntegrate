package demo.zjm._10新特性._08Stream中间操作_映射;

import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //<R> Stream<R> map(Function<? super T, ? extends R> mapper);
        //将流中的数据用function按每个元素传入，映射得到新的数据
        Stream.of(1, 2, 3, 4, 5).map(t -> t + 1).forEach(System.out::println);

        //扁平化映射
        String[] arrayOfWords = {"Hello", "World"};
        Stream stream = null;
        //原本用map来做，就会得到真正的流中流，需要两层foreach来操作
        stream = Arrays.stream(arrayOfWords).map(word -> word.split("")).map(Arrays::stream);
        stream.forEach(t -> ((Stream) t).forEach(System.out::println));
        //使用flatMap映射后只需要一层就能输出为元素
        //原因就是扁平化映射过程自己把流中流展开，扩充成为了外层流的数据元素
        stream = Arrays.stream(arrayOfWords).map(word -> word.split("")).flatMap(Arrays::stream);
        Arrays.stream(arrayOfWords).map(word -> word.split("")).flatMap(Arrays::stream).forEach(System.out::println);
        //发现流本身是流中有流状态，也可以直接扁平化
        Stream.of(Stream.of(1, 2), Stream.of(3, 4, 5)).flatMap(t -> t).forEach(System.out::println);
    }
}
