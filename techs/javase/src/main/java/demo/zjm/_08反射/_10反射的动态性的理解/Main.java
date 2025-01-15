package demo.zjm._08反射._10反射的动态性的理解;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int num = new Random().nextInt(3);//0,1,2
            String classPath = "";
            switch (num) {
                case 0:
                    classPath = "java.util.Date";
                    break;
                case 1:
                    classPath = "java.lang.Object";
                    break;
                case 2:
                    classPath = "反射._10反射的动态性的理解.a.Main";
                    break;
            }

            try {
                Object obj = getInstance(classPath);
                System.out.println(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static Object getInstance(String classPath) throws Exception {
        //反射的本质问题，不知道创建的对象是什么，允许这样则非常灵活
        Class clazz = Class.forName(classPath);
        return clazz.newInstance();
    }
}
