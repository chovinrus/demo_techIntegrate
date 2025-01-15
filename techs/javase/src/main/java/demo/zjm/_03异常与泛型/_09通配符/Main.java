package demo.zjm._03异常与泛型._09通配符;

import java.util.ArrayList;
import java.util.List;

class C {

}

class Son extends C {

}

public class Main {
    public static void main(String[] args) {
        List<? extends C> list = new ArrayList<>();
        list = new ArrayList<C>();
        list = new ArrayList<Son>();

        //带通配符泛型参数的类型不能进行修改操作
        //Required type:
        //capture of ? extends C
        //Provided:
        //Son
        //list.add(new Son());

        ((ArrayList<Son>) list).add(new Son());
        list.add(null);

        //获取元素将是通配符的顶级父类
        C c = list.get(0);

        List<? super Son> list1 = new ArrayList<>();
        list1 = new ArrayList<Son>();
        list1 = new ArrayList<C>();

        //同样不允许修改操作
        //list.add(new C());

        ((List<C>) list1).add(new Son());

        //获取也是顶级父类
        Object object = list1.get(0);
    }
}
