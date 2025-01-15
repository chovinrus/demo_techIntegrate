package demo.zjm._07IO与网络编程._05用数组辅助读写操作;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File file = new File("src/_07IO与网络编程/_05用数组辅助读写操作/word.txt");
        FileReader fr = null;
        long t0 = System.nanoTime();
        try {
            fr = new FileReader(file);
            char[] chars = new char[1024];
            try {
                int len = 0;
                while ((len = fr.read(chars)) != -1)
                    System.out.print(new String(chars, 0, len));
                //helloworld
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        long t1 = System.nanoTime();
        System.out.println("\n" + (t1 - t0));
    }
}
