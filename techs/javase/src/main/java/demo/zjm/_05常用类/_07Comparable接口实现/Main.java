package demo.zjm._05常用类._07Comparable接口实现;

import java.util.Arrays;

class Obj implements Comparable {
    int field;

    public Obj(int field) {
        this.field = field;
    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(this.field, ((Obj) o).field);
    }

    @Override
    public String toString() {
        return "Obj{" +
                "field=" + field +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        Obj[] objs = {new Obj(2), new Obj(1), new Obj(4)};
        Arrays.sort(objs);
        System.out.println(Arrays.toString(objs));
        //[Obj{field=1}, Obj{field=2}, Obj{field=4}]
    }
}
