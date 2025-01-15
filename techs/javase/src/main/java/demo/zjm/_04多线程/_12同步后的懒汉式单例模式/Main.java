package demo.zjm._04多线程._12同步后的懒汉式单例模式;

public class Main {
    static Main main;

    public Main getMain() {
        //注意两层判断的意义
        if (main == null) //外层用于提高获取单例的效率
            synchronized (Main.class) {
                if (main == null) //内层用于保证线程安全
                    main = new Main();
            }
        return main;
    }
}
