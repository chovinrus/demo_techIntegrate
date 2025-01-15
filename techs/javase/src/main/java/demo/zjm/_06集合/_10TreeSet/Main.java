package demo.zjm._06集合._10TreeSet;

import java.util.Iterator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<Integer> integers = new TreeSet<>();
        integers.add(3);
        integers.add(1);
        integers.add(2);
        integers.add(4);
        integers.add(4);
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
        //1
        //2
        //3
        //4
    }
}
