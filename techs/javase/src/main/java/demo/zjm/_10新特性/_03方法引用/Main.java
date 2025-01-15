package demo.zjm._10新特性._03方法引用;

@FunctionalInterface
interface Consumer {
    void accept(Integer num);
}

interface BiConsumer {
    void accept1(Main main, Integer num0, Integer num1);
}

public class Main {
    static void accept1(Integer num) {
        System.out.println(num + 1);
    }

    public static void main(String[] args) {
        //三种方法引用的形式
        //对象::成员方法
        Consumer consumer = new Main()::accept;
        consumer.accept(3);//3

        //类::类方法
        consumer = Main::accept1;
        consumer.accept(3);//4

        //类::实例方法
        //考虑将形参的第一个作为引用的方法的调用者。
        //这样的话被引用方法就比接口方法少一个形参
        BiConsumer biConsumer = Main::accept;
        biConsumer.accept1(new Main(), 250, 250);//250 250
    }

    void accept(Integer num) {
        System.out.println(num);
    }

    void accept(Integer num, Integer num1) {
        System.out.println(num + " " + num1);
    }
}
