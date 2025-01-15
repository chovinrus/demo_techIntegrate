package demo.zjm._02面向对象._04包装类;

public class Main {

    static int intNum = 100;

    public static void main(String[] args) {
        //装箱拆箱是基本数据类型和包装类型的相互转换
        //装箱： 基本类型 -> 包装类对象
        Integer integer = new Integer(250);
        //拆箱:  包装类对象 -> 基本类型
        int intNum = integer.intValue();
        //自动装箱、自动拆箱
        integer = 250;
        intNum = integer;

        //包装数据类型与String转换
        String str = String.valueOf(integer);
        integer = new Integer(str);

        //基本数据类型与String类型转换
        intNum = Integer.parseInt(str);
        str = String.valueOf(intNum);
        str = intNum + "";

        System.out.println(Main.intNum);
    }
}
