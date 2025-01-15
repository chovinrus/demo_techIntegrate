package demo.zjm._08_原型模式.client;

import demo.zjm._08_原型模式.propetype.DeepConcretePrototype;
import demo.zjm._08_原型模式.propetype.ShallowConcretePrototype;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.util.SerializationUtils;

/**
 * @program: DesignPattern
 * @ClassName: Client
 * @description:
 * @author: AlanMa
 * @create: 2024-01-13 10:59
 */
public class Client {
    @Test
    public void test01() throws CloneNotSupportedException {
        ShallowConcretePrototype c1 = new ShallowConcretePrototype();
        ShallowConcretePrototype c2 = c1.clone();
        DeepConcretePrototype c3 = new DeepConcretePrototype();
        DeepConcretePrototype c4 = c3.clone();
        Object o1 = c1.getO();
        Object o2 = c2.getO();
        Object o3 = c3.getO();
        Object o4 = c4.getO();
        //具体的原型对象创建完成!
        //具体的原型对象复制成功!
        //具体的原型对象创建完成!
        //具体的原型对象复制成功!

        System.out.println("对象c1和c2是同一个对象？" + (c1 == c2));
        System.out.println("对象c1和c2是同一个对象？" + (c3 == c4));
        System.out.println("对象o1和o2是同一个对象？" + (o1 == o2));
        System.out.println("对象o3和o4是同一个对象？" + (o3 == o4));
        //对象c1和c2是同一个对象？false
        //对象c1和c2是同一个对象？false
        //对象o1和o2是同一个对象？true
        //对象o3和o4是同一个对象？false

        DeepConcretePrototype c5 = new DeepConcretePrototype();
        BeanUtils.copyProperties(c3, c5);
        Object o5 = c5.getO();
        System.out.println("对象o3和o5是同一个对象？" + (o3 == o5));
        System.out.println("对象o3和o5是属性相等？" + (o3.equals(o5)));
        DeepConcretePrototype c6 = SerializationUtils.clone(c3);
        Object o6 = c6.getO();
        System.out.println("对象o3和o6是同一个对象？" + (o3 == o6));
        System.out.println("对象o3和o6是属性相等？" + (o3.equals(o5)));
        //对象o3和o5是同一个对象？true
        //对象o3和o5是属性相等？true
        //对象o3和o6是同一个对象？false
        //对象o3和o6是属性相等？true

    }

}
