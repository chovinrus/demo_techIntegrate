package demo.zjm._03异常与泛型._10DAO;

public class DAO<T> {
    public boolean add(T t) {
        return true;
    }

    public boolean del(T t) {
        return true;
    }

    public boolean upd(T t) {
        return true;
    }

    public T query(String str) {
        T t = null;
        return t;
    }
}
