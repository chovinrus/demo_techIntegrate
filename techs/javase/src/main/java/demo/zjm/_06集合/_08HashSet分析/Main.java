package demo.zjm._06集合._08HashSet分析;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<Object> objects = new HashSet<>();
        objects.add(0);
        //private transient HashMap<E,Object> map;

        //PRESENT只是作为一个占位符使用
        //private static final Object PRESENT = new Object();

        //public HashSet() {
        //        map = new HashMap<>();
        //    }

        //public boolean add(E e) {
        //        return map.put(e, PRESENT)==null;
        //    }

        //加载因子
        //static final float DEFAULT_LOAD_FACTOR = 0.75f;
    }
}
