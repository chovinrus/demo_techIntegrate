package demo.zjm._06集合._07Set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

class Obj {
    String field;

    public Obj(String field) {
        this.field = field;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Obj obj = (Obj) o;
        return Objects.equals(field, obj.field);
    }

    @Override
    public String toString() {
        return "Obj{" +
                "field='" + field + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(field);
    }
}

public class Main {
    public static void main(String[] args) {
        HashSet set = new HashSet();
        set.add('w');
        set.add(2);
        set.add("sa");
        set.add(new String("sa"));
        set.add(new Obj("对象1"));
        set.add(new Obj("对象1"));
        //发现每次运行结果都一样
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
    }
}
