package demo.zjm._08反射._02Class类四种获取方式;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        //类名.class
        Class<demo.zjm._08反射._01Class初步理解.Main> mainClass = demo.zjm._08反射._01Class初步理解.Main.class;
        System.out.println(mainClass);

        //getClass
        String str = "略略略";
        System.out.println(str.getClass());

        //Class.forName()
        Class aClass = Class.forName("java.lang.String");
        System.out.println(aClass);

        //ClassLoader
        //随意搞一个应用类加载器ClassLoader对象就行
        ClassLoader classLoader = mainClass.getClassLoader();
        ClassLoader classLoader1 = String.class.getClassLoader();
        Class aClass1 = classLoader.loadClass("demo.zjm._08反射._01Class初步理解.AClass");
        System.out.println(aClass1);    //class 反射.Class初步理解.AClass
    }
}
