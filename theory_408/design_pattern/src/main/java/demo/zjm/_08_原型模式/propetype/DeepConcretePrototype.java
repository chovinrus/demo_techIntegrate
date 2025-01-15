package demo.zjm._08_原型模式.propetype;

import lombok.Getter;
import lombok.Setter;

import java.io.*;

/**
 * @program: DesignPattern
 * @ClassName: p
 * @description:
 * @author: AlanMa
 * @create: 2024-01-12 10:43
 */
@Getter
@Setter
public class DeepConcretePrototype implements Cloneable, Serializable {
    public DeepConcretePrototype() {
        System.out.println("具体的原型对象创建完成!");
    }

    private Obj o = new Obj();

    @Override
    public DeepConcretePrototype clone() throws CloneNotSupportedException {
        DeepConcretePrototype cloneObj = null;
        try {
            //创建对象序列化输出流
            ObjectOutputStream oos = null;
            oos = new ObjectOutputStream(new
                    FileOutputStream("c.obj"));
            //将c1对象写到文件中
            oos.writeObject(this);
            oos.close();
            //创建对象序列化输入流
            ObjectInputStream ois = new ObjectInputStream(new
                    FileInputStream("c.obj"));
            //读取对象
            cloneObj = (DeepConcretePrototype) ois.readObject();
            System.out.println("具体的原型对象复制成功!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return cloneObj;
    }
}

