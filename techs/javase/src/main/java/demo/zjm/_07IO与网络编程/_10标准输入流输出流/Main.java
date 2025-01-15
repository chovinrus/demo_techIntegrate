package demo.zjm._07IO与网络编程._10标准输入流输出流;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        //这是我们平时的输入方式
        Scanner scanner = new Scanner(System.in);
        //这是直接使用标准输入流的方式
        byte[] buf = new byte[256];
        int len = 0;
        //EOF也就是-1输入方式是Ctrl + D，这个可不兴乱输啊，操作完整个控制台都将退出
        //System.out.println(System.in.read());
//        while ((len = System.in.read(buf)) != -1) {
//            String out = new String(buf, 0, len);
//            System.out.println(out);
//        }

        //切换System.in的输入源
//        System.setIn(new FileInputStream(
//                new File("src/_07IO与网络编程/_10标组输入流输出流/word.txt")));
//        while ((len = System.in.read(buf)) != -1) {
//            String out = new String(buf, 0, len);
//            System.out.print(out);
//        }

        //做一个OJ平台输入的典型处理
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bR = new BufferedReader(inputStreamReader);
        String str = null;
        while (!"exit".equals(str)) {
            str = bR.readLine();
            System.out.println(str);
        }
    }
}
