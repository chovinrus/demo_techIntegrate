package demo.zjm._03异常与泛型._4泛型;

class c<T> {
    T t;

    public c(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "transient关键字.c{" +
                "t=" + t +
                '}';
    }
}


public class Main {
    public static void main(String[] args) {
        c<String> c = new c<>("zz");
        System.out.println(c);
    }
}
