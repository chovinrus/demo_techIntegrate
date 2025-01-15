package demo.zjm._07IO与网络编程._11数据流;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(new File("src/_07IO与网络编程/_11数据流/word.txt"));
        FileOutputStream fos = new FileOutputStream(new File("src/_07IO与网络编程/_11数据流/word.txt"));
        DataOutputStream dos = new DataOutputStream(fos);
        DataInputStream dis = new DataInputStream(fis);

        dos.writeInt(110);
        dos.writeBoolean(true);
        dos.writeUTF("中国共产党万岁");

        System.out.println(dis.readInt());
        System.out.println(dis.readBoolean());
        System.out.println(dis.readUTF());

        dis.close();
        dos.close();
    }
}
