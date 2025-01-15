package demo.zjm._02面向对象._17自定义枚举类;

class Season {
    public static final Season SPRING = new Season("春天", "温暖");
    public static final Season SUMMER = new Season("夏天", "炎热");
    public static final Season FALL = new Season("秋天", "凉爽");
    public static final Season WINTER = new Season("冬天", "寒冷");
    private String name;
    private String disc;

    private Season(String name, String disc) {
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
        System.out.println(Season.SUMMER);
        //Season{name='夏天', disc='炎热'}
    }
}
