package demo.zjm._03异常与泛型._07不能使用泛型数组初始化;

class GenericClass<T> {
    T[] arr;

    public void fun() {
        //Type parameter 'T' cannot be instantiated directly
        //arr = new T[3];
        arr = (T[]) new Object[4];
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
