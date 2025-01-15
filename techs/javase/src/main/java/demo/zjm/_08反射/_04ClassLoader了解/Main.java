package demo.zjm._08反射._04ClassLoader了解;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(Main.class.getClassLoader());
        //sun.misc.Launcher$AppClassLoader@18b4aac2
        //即系统类加载器

        System.out.println(String.class.getClassLoader());
        //null
        //引导类加载器无法直接获取

        //获取下引导类加载器
        System.out.println(Main.class.getClassLoader().getParent());
        //sun.misc.Launcher$ExtClassLoader@74a14482

        //来看下Object由谁来加载
        System.out.println(Class.forName("java.lang.Object").getClassLoader());
        //null
        //啊果然是由系统类加载器加载的
    }
}
