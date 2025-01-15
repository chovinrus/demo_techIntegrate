package demo.zjm._10新特性._12Optional类;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        //创建Optional对象
        //of要求非空
        Optional<Integer> integer = Optional.of(3);
        System.out.println(integer);    //Optional[3]
        //ofNullable允许为空
        Optional<Object> o = Optional.ofNullable(null);
        System.out.println(o);  //Optional.empty
        //empty直接得到value为null的Optional对象
        Optional<Object> empty = Optional.empty();
        System.out.println(empty);  //Optional.empty

        //isPresent()返回Optional对象的value是否为null
        System.out.println(o.isPresent());  //false
        //public void ifPresent(Consumer<? super T> consumer)
        integer.ifPresent(System.out::println); //3
        empty.ifPresent(System.out::println);

        //获取Opthional对象的value对象
        System.out.println(integer.get().getClass());   //class java.lang.Integer
        //orElse(T other) 有值直接返回value对象，value为null则返回传入的对象other
        System.out.println(empty.orElse(250));
        System.out.println(empty.orElse(250).getClass());
        //public T orElseGet(Supplier<? extends T> other)
        //有值直接返回，无值则由other提供
        System.out.println(empty.orElseGet(() -> 250));
        System.out.println(empty.orElseGet(() -> 250).getClass());
        //250
        //class java.lang.Integer
        //250
        //class java.lang.Integer
        //public <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier) throws X
        //类似于上面这个不过要求other提供的必须是Exception对象
        try {
            System.out.println(empty.orElseThrow(() -> new Exception()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
