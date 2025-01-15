package demo.zjm._07IO与网络编程._09转换流;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        File file = new File("src/_07IO与网络编程/_09转换流/word.txt");
        FileInputStream fis = null;
        InputStreamReader isr = null;
        try {
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis, "utf-8");
            char[] buf = new char[256];
            int len = 0;
            while ((len = isr.read(buf)) != -1) {
                System.out.println(String.copyValueOf(buf, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
