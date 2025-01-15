package demo.zjm._07IO与网络编程._12对象流;

import java.io.*;

class obj implements Serializable {
    private static final long serialVersionUID = -6849794470754663521L;
    int num;
    String str;
    boolean aBoolean;

    public obj(int num, String str, boolean aBoolean) {
        this.num = num;
        this.str = str;
        this.aBoolean = aBoolean;
    }

    @Override
    public String toString() {
        return "obj{" +
                "num=" + num +
                ", str='" + str + '\'' +
                ", aBoolean=" + aBoolean +
                '}';
    }
}

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("src/_07IO与网络编程/_12对象流/word.txt");
        File file1 = new File("src/_07IO与网络编程/_12对象流/word.txt");
        FileInputStream fis = new FileInputStream(file);
        FileInputStream fis1 = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(file);

        //注意下面两行的顺序是不能随意更改的
        //因为原先的文件不是由对象流序列化得到的，具体的缘故以后再研究
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        ObjectInputStream ois = new ObjectInputStream(fis);

        oos.writeObject(new obj(1, "朱建民", true));
        oos.writeInt(250);
        oos.close();

        System.out.println(ois.readObject());//obj{num=1, str='朱建民', aBoolean=true}
        System.out.println(ois.readInt());//250
        ois.close();
    }
}
