package demo.zjm._08反射._03各种数据类型的Class获取;

public class Main {
    public static void main(String[] args) {
        //- class
        //  没啥好说的

        //- interface
        System.out.println(Comparable.class);

        //- []
        System.out.println(int[].class);

        //- enum
        System.out.println(AEnum.class);

        //- annotation
        System.out.println(Override.class);

        //- primitive type
        System.out.println(int.class);

        //- void
        System.out.println(void.class);

        //interface java.lang.Comparable
        //class [I
        //class 反射.各种数据类型的Class获取.AEnum
        //interface java.lang.Override
        //int
        //void
    }
}
