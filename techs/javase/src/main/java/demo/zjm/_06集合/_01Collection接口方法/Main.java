package demo.zjm._06集合._01Collection接口方法;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //add、addAll
        Collection collection = new ArrayList();
        collection.add('2');
        collection.add(2);//这里自动装箱
        System.out.println(collection);//[2, 2]
        collection.addAll(collection);
        System.out.println(collection);//[2, 2, 2, 2]
        //返回类型是boolean，若原Collection改变才返回true
        System.out.println(collection.addAll(new ArrayList()));//false

        //size
        System.out.println(collection.size());//4

        //clear
        collection.clear();

        //isEmpty
        System.out.println(collection.isEmpty());//true

        //contains、containsAll
        collection.add(1);
        collection.contains(1);//true
        collection.add(2);
        collection.add(3);
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(3);
        collection.containsAll(arrayList);//true

        //remove
        collection.remove(3);
        System.out.println(collection);//[1, 2]
        collection.removeAll(collection);//求差集
        System.out.println(collection);//[]

        //retain求交集
        collection.add(1);
        collection.add(2);
        collection.retainAll(arrayList);
        System.out.println(collection);//[1]

        //remove按值移除所有
        collection.add(1);
        collection.add(1);
        collection.removeAll(Arrays.asList(1));
        System.out.println(collection);
        collection.add(1);//[]

        //与数组的相互转换
        Object[] objects = collection.toArray();
        List<Object> objects1 = Arrays.asList(objects);
        //这样获得的List实际是内部类
        System.out.println(objects1.getClass());//class java.util.Arrays$ArrayList
        System.out.println(objects.getClass().getSuperclass());//class java.lang.Object
        //这里的ArrayList内部类是定义在Arrays内部的静态内部类，且没有提供增删方法
        //private static class ArrayList<E> extends AbstractList<E>
        //UnsupportedOperationException
        //objects1.add(2);
        //objects1.remove(1);
        System.out.println(objects1.get(0));//1
        objects1.set(0, 4);
        System.out.println(objects1);//[4]

        //注意Arrays.asList的参数是泛型可变形参，因此是识别对象数组，基本类型数组就只能当做一个对象
        System.out.println(Arrays.asList(new int[]{1, 2}).size());
        System.out.println(Arrays.asList(new Integer[]{1, 2}).size());
        System.out.println(Arrays.asList(1, 2).size());

        //获得迭代器
        Iterator iterator = collection.iterator();
    }
}
