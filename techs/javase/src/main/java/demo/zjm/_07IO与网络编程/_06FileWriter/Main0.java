package demo.zjm._07IO与网络编程._06FileWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main0 {
    public static void main(String[] args) {
        File file = new File("src/_07IO与网络编程/_06FileWriter/word.txt");
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
            //这里注意append参数默认是false，即直接覆盖原来的文件，设置为true才会进行追加
            //fw = new FileWriter(file.txt, true);
            fw.write("--");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
