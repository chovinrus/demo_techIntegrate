package demo.zjm._03异常与泛型._08泛型方法;

import java.util.Arrays;
import java.util.List;

class C<T> {
    public <E> List<E> fun(E[] es) {
        return Arrays.asList(es);
    }
}

public class Main {
    public static void main(String[] args) {
        C<String> c = new C<>();
        List<Integer> fun = c.fun(new Integer[]{1, 2, 3});
        System.out.println(fun);//[1, 2, 3]
    }
}
