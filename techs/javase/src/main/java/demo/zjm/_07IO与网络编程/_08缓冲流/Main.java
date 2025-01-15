package demo.zjm._07IO与网络编程._08缓冲流;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            File file = new File("src/_07IO与网络编程/_08缓冲流/word.txt");
            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos = new FileOutputStream(file);
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
