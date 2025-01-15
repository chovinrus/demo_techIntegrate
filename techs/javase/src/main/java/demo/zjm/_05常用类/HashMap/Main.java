package demo.zjm._05常用类.HashMap;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("1", 3);
        hashMap.put("1", 4);
        hashMap.put("2", 4);
        System.out.println(hashMap);//{1=4, 2=4}

        //remove
        Object remove = hashMap.remove("1");
        System.out.println(hashMap);//{2=4}
        System.out.println(remove);//4

        //putAll
        HashMap hashMap1 = new HashMap();
        hashMap.put("zz", 14);
        hashMap.put("zx", 145);
        hashMap.putAll(hashMap1);
        System.out.println(hashMap);//{zz=14, 2=4, zx=145}

        //containsKey
        System.out.println(hashMap.containsKey("1"));//false
        System.out.println(hashMap.containsKey("2"));//true
        //containsvalue
        System.out.println(hashMap.containsValue(14));//true


        //遍历键和值
        Set keySet = hashMap.keySet();
        hashMap.put("zx", 14);
        Collection values = hashMap.values();
        Set entrySet = hashMap.entrySet();
        for (Iterator iterator = keySet.iterator(); iterator.hasNext(); ) {
            Object next = iterator.next();
            System.out.println(next);
        }
        //zz
        //2
        //zx
        for (Iterator iterator = values.iterator(); iterator.hasNext(); ) {
            Object next = iterator.next();
            System.out.println(next);
        }
        //14
        //4
        //14
        for (Iterator iterator = entrySet.iterator(); iterator.hasNext(); ) {
            Object next = iterator.next();
            System.out.println(((Map.Entry) next).getKey() + " " + ((Map.Entry) next).getValue());
        }

        //clear
        hashMap.clear();
        System.out.println(hashMap);//{}
        System.out.println(hashMap.isEmpty());//true
    }
}
