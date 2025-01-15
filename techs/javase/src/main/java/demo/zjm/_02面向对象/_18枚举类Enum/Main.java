package demo.zjm._02面向对象._18枚举类Enum;

enum Season {
    //必须放前面
    SPRING("c春天", "温暖"),
    SUMMER("夏天", "炎热"),
    FALL("秋天", "凉爽"),
    WINTER("冬天", "寒冷");

    String name;
    String disc;

    Season(String name, String disc) {
        this.name = name;
        this.disc = disc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", disc='" + disc + '\'' +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Season.SUMMER);//Season{name='夏天', disc='炎热'}
        System.out.println(Season.SPRING.getClass().getSuperclass());//class java.lang.Enum
        for (Object o :
                Season.values()) {
            System.out.println(o);
        }
        //Season{name='c春天', disc='温暖'}
        //Season{name='夏天', disc='炎热'}
        //Season{name='秋天', disc='凉爽'}
        //Season{name='冬天', disc='寒冷'}
        System.out.println(Season.valueOf("WINTER"));
        //Season{name='冬天', disc='寒冷'}
    }
}
