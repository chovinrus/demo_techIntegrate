package demo.zjm._06集合._02迭代器;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.println(next);
        }
        iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.println(next);
            if (next == 2) {
                //这是迭代器的remove方法，效果会作用于原来的Collection
                //若集合并没有提供remove方法，会报错，比如Arrays$ArrayLists
                //iterator.remove();//这个只允许对迭代到的当前对象进行remove
                list.remove(Integer.valueOf(3));
//                list.remove(Integer.valueOf(3));//ConcurrentModificationException
            }
        }
        List<Integer> integers = Collections.synchronizedList(list);
        System.out.println(list);//[1,3]
    }

//    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            list.add(i + "");
//        }
//        Iterator<String> iterator = list.iterator();
//        int i = 0;
//        while (iterator.hasNext()) {
//            if (i == 3) {
//                System.out.println("-");
//                list.remove(Integer.valueOf(1));
//            }
//            System.out.println(iterator.next());
//            i++;
//        }
//        System.out.println(list);
//    }
}
