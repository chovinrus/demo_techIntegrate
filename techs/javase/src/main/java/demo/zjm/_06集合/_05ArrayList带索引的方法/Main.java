package demo.zjm._06集合._05ArrayList带索引的方法;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        Integer set = integers.set(0, 2);
        System.out.println(set);//1
        System.out.println(integers);//[2]
        integers.add(1, 2);
        integers.add(0, 3);
        System.out.println(integers);//[3, 2, 2]

        //两种remove
        integers.remove(0);
        System.out.println(integers);//[2,2]
        integers.remove(new Integer(2));
        System.out.println(integers);//[2]

        //indexOf、lastIndextOf
        System.out.println(integers.indexOf(2));//0
        System.out.println(integers.lastIndexOf(2));//0

        integers.add(1);
        integers.add(3);
        List<Integer> list = integers.subList(0, 2);
        System.out.println(list);//[2,1]
    }
}
