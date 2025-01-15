package demo.zjm._06集合._06LinkedList方法;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> integers = new LinkedList<>();
        integers.add(3);
        integers.addFirst(2);
        integers.addLast(5);
        System.out.println(integers);//[2,3,5]
        System.out.println(integers.getFirst());//2
        System.out.println(integers.getLast());//5
        integers.removeFirst();
        integers.removeLast();
        System.out.println(integers);//[2]
    }
}
