package demo.zjm._05常用类._01String的内存位置理解;

public class Main {
    public static void main(String[] args) {
        //内容为空的对象final char[0] value
        System.out.println(new String().hashCode());

        //理解字符常量序列的意义
        String str1 = "str";
        String str2 = "str";
        String str3 = new String("str");
        String str4 = new String("str");
        System.out.println(str1 == str2);//true
        System.out.println(str1 == str3);//false
        System.out.println(str3 == str4);//false

        //+连接符
        String str = "strstr";
        String str5 = str1 + str2;
        String str6 = "str" + "str";
        String str7 = "str" + str1;
        System.out.println(str == str5);//false
        System.out.println(str == str6);//true
        System.out.println(str == str7);//false

//        /**
//         * 测试代码
//         */
//        public class Test {
//            public static void main(String[] args) {
//                int i = 10;
//                String s = "abc";
//                System.out.println(s + i);
//            }
//        }
//        /**
//         * 反编译后
//         */
//        public class Test {
//            public static void main(String args[]) { //删除了默认构造函数和字节码
//                byte byte0 = 10;
//                String s = "abc";
//                System.out.println((new StringBuilder()).append(s).append(byte0).toString());
//            }
//        }

        //如果是字面量的常量，就和常量完全一样
        final String str8 = "str";
        System.out.println(str8 + "str" == str);//true

        //intern获取常量池的常量
        System.out.println(str7.intern() == str);//true
    }
}
