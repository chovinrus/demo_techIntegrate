package demo.zjm._07IO与网络编程._07InputStream_OutputStream的使用;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File file = new File("src/_07IO与网络编程/_07Stream的使用/朱建民的头像.jpg");
            File file1 = new File("src/_07IO与网络编程/_07Stream的使用/朱建民的头像1.jpg");
            fis = new FileInputStream(file);
            fos = new FileOutputStream(file1);
            byte[] buf = new byte[256];
            int len = 0;
            while ((len = fis.read(buf)) != -1) {
                fos.write(buf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
