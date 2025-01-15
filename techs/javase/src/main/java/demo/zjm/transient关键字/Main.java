package demo.zjm.transient关键字;

import java.io.*;

/**
 * @program: JavaSE' Code
 * @ClassName: transient关键字.c
 * @description:
 * @author: AlanMa
 * @create: 2024-01-26 14:58
 */

class c implements Serializable {
    int a;
    transient int b;

    public c(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public c() {
    }

    @Override
    public String toString() {
        return "c{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        c c1 = new c(1, 1);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("c1.obj"));
        oos.writeObject(c1);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("c1.obj"));
        c o = (c) ois.readObject();
        System.out.println(o);//c{a=1, b=0}
    }
}
