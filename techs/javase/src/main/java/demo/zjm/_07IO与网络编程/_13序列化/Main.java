package demo.zjm._07IO与网络编程._13序列化;

import java.io.*;


public class Main implements Serializable {

    private static final long serialVersionUID = -6849792470754663521L;
    private static int num = 39;

    private int n1;
    private String str;
    private char c;

    public Main(int num, int n1, String str, char c) {
        this.num = num;
        this.n1 = n1;
        this.str = str;
        this.c = c;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("src/_07IO与网络编程/_13序列化/save.dat");
        //这里我们注意当把最近一次的写操作注释掉执行结果和保留会不一样
//        FileOutputStream fos = new FileOutputStream(file);
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        oos.writeObject(new Main(3,1,"朱建民帅比",'transient关键字.c'));
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        System.out.println(ois.readObject());
        //这是写完就读的
        //Main{num=3,n1=1, str='朱建民帅比', transient关键字.c=transient关键字.c}
        //这是执行程序只有的读的
        //Main{num=39,n1=1, str='朱建民帅比', transient关键字.c=transient关键字.c}

//        oos.close();
        fis.close();
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public void setC(char c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "Main{" +
                "num=" + num +
                ",n1=" + n1 +
                ", str='" + str + '\'' +
                ", transient关键字.c=" + c +
                '}';
    }
}
