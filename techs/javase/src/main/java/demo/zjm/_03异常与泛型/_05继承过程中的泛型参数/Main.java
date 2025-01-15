package demo.zjm._03异常与泛型._05继承过程中的泛型参数;


class Base<T> {
    T t;

    public Base(T t) {
        this.t = t;
    }
}

class Sub0 extends Base<Integer> {
    public Sub0(Integer integer) {
        super(integer);
    }
}

class Sub1 extends Base {
    public Sub1(Object o) {
        super(o);
    }
}

//继承父类的泛型参数，还是要在当前类中指明
class Sub2<T, E> extends Base<T> {
    E e;

    public Sub2(T t, E e) {
        super(t);
        this.e = e;
    }

}

public class Main {
    public static void main(String[] args) {
        Sub0 main = new Sub0(3);
        //报错:Sub1' does not have type parameters
        //Sub1<Integer> c1 = new Sub1<>(4);
        Sub2<String, Integer> zz = new Sub2<>("zz", 2);
    }
}
