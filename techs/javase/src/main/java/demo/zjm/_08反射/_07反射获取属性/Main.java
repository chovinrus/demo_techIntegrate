package demo.zjm._08反射._07反射获取属性;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class
Main {
    public String field;
    String field1;

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException {

        //获取所有属性
        for (Field field : Main.class.getFields()) {
            System.out.println(field);
        }
        //public java.lang.String 反射._07反射获取属性和方法.a.Main.field

        //获取和设置属性
        Field field = Main.class.getField("field");
        //报错发现getField也有对public的检查
        //Field field1 = a.Main.class.getField("field1");
        System.out.println(field);//public java.lang.String 反射._07反射获取属性和方法.a.Main.field
        Main main = new Main();
        field.set(main, "啦啦啦");
        System.out.println(main); //a.Main{field='啦啦啦', field1='null'}

        //Field对象的一些方法
        System.out.println(field.getType());
        //注意Field的这个toString方法，可以将数值型的修饰符获得结果转为对应的字符串
        System.out.println(Modifier.toString(field.getModifiers()));
        System.out.println(field.getName());
        //class java.lang.String
        //public
        //field
    }

    @Override
    public String toString() {
        return "a.Main{" +
                "field='" + field + '\'' +
                ", field1='" + field1 + '\'' +
                '}';
    }
}
