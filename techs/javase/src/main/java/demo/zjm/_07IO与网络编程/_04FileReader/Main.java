package demo.zjm._07IO与网络编程._04FileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File file = new File("src/_07IO与网络编程/_04FileReader/word.txt");
        FileReader fileReader = null;
        long t0 = System.nanoTime();

        try {
            fileReader = new FileReader(file);
            int c;
            while ((c = fileReader.read()) != -1) {
                System.out.print((char) c);
            }
            //helloworld
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null)
                    fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        long t1 = System.nanoTime();
        System.out.println(t1 - t0);
    }
}
