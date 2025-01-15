package demo.zjm._07IO与网络编程._03文件流操作的异常处理;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File file = new File("src/_07IO与网络编程/_03FileReader/word.txt");
        //fileReader声明在try外面以便允许使用close，即使创建失败也能用
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                //注意流创建失败的情形
                if (fileReader != null)
                    fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
