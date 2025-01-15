package demo.zjm._05常用类._08定制排序;

import java.util.Arrays;
import java.util.Comparator;

class Obj {
    int field;

    public Obj(int field) {
        this.field = field;
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
        Arrays.sort(objs, new Comparator<Obj>() {
            @Override
            public int compare(Obj o1, Obj o2) {
                return -Integer.compare(o1.field, o2.field);
            }
        });
        System.out.println(Arrays.toString(objs));
        //[Obj{field=4}, Obj{field=2}, Obj{field=1}]
    }
}
