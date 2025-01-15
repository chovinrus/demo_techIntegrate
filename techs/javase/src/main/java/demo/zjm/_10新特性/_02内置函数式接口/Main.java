package demo.zjm._10新特性._02内置函数式接口;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    //消耗型
    //void accept(T t);
    Consumer<Integer> consumer = n -> {
    };

    //供给型
    //T get();
    Supplier<Integer> supplier = () -> 3;

    //函数型
    //Function<T, R>
    //R apply(T t)
    Function<Integer, String> function = n -> n.toString();

    //断言型
    //Predicte<T>
    //boolean test(T t);
    Predicate<Integer> predicate = n -> n > 0 ? true : false;
}
