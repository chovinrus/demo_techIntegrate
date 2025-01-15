package demo.zjm._07IO与网络编程._14RandomAccessFile;

import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {

    public static void main(String[] args) throws IOException {
        RandomAccessFile rwW =
                new RandomAccessFile("src/_07IO与网络编程/_14RandomAccessFile/word0.txt", "rw");
        RandomAccessFile rwR =
                new RandomAccessFile("src/_07IO与网络编程/_14RandomAccessFile/word.txt", "rw");
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = rwR.read(buf)) != -1) {
            rwW.write(buf, 0, len);
        }
        RandomAccessFile rwR0 =
                new RandomAccessFile("src/_07IO与网络编程/_14RandomAccessFile/word0.txt", "rw");
        while ((len = rwR0.read(buf)) != -1) {
            System.out.print(new String(buf, 0, len, "utf-8"));
        }
        rwR.close();
        rwR0.close();
        rwW.close();
    }

    @Test
    public void overwriteTest() throws IOException {
        RandomAccessFile rwW =
                new RandomAccessFile("src/_07IO与网络编程/_14RandomAccessFile/word0.txt", "rw");
        rwW.write("朱建民帅比".getBytes("utf-8"));
        rwW.close();
    }

    @Test
    public void seekTest() throws IOException {
        RandomAccessFile rwW =
                new RandomAccessFile("src/_07IO与网络编程/_14RandomAccessFile/word0.txt", "rw");
        System.out.println(rwW.getFilePointer());//0
        rwW.seek(12);
        System.out.println(rwW.getFilePointer());//0
        rwW.write("爆".getBytes("utf-8"));
        rwW.close();
    }
}
