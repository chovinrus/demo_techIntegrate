package demo.zjm._10新特性._11Stream终止操作_归约和收集;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //reduce传入的是BinaryOperator，元素之间照着apply
        //类似于这样
        //T result = identity;
        //for (int i = 0; i < n; i++) {
        //	result = accumulator.apply(result, a[i]);
        //}
        //return result;
        System.out.println(Stream.of(1, 2, 3).reduce(Integer::sum));    //Optional[6]
        System.out.println(Stream.of(4, 2, 2).reduce(32, (n1, n2) -> n1 / n2));  //2

        //<R, A> R collect(Collector<? super T, A, R> collector);
        //collect传入收集器，可以将流中的数据收集到具体的容器
        //Collctors提供一系列静态方法获取相应的收集器对象
        System.out.println(Stream.of(1, 2, 3).collect(Collectors.toList()).getClass());
    }
}
