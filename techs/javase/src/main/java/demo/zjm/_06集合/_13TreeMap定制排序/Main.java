package demo.zjm._06集合._13TreeMap定制排序;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

class User {
    String name;
    int Age;

    public User(String name, int age) {
        this.name = name;
        Age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", Age=" + Age +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        TreeMap<User, String> userStringTreeMap = new TreeMap<User, String>((u1, u2) -> Integer.compare(u2.Age, u1.Age));
        userStringTreeMap.put(new User("朱建民", 24), "巨帅");
        userStringTreeMap.put(new User("郭大敏", 23), "一般帅");
        userStringTreeMap.put(new User("朱纪雨", 22), "嘎嘎不帅");
        Iterator<Map.Entry<User, String>> iterator = userStringTreeMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<User, String> next = iterator.next();
            System.out.println(next.getKey() + " " + next.getValue());
        }
        //User{name='朱建民', Age=24} 巨帅
        //User{name='郭大敏', Age=23} 一般帅
        //User{name='朱纪雨', Age=22} 嘎嘎不帅
    }
}
