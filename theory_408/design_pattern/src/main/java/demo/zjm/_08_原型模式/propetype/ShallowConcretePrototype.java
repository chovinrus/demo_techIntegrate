package demo.zjm._08_原型模式.propetype;

import lombok.Getter;

/**
 * @program: DesignPattern
 * @ClassName: p
 * @description:
 * @author: AlanMa
 * @create: 2024-01-12 10:43
 */
@Getter
public class ShallowConcretePrototype implements Cloneable {

    Object o = new Obj();

    public ShallowConcretePrototype() {
        System.out.println("具体的原型对象创建完成!");
    }

    @Override
    public ShallowConcretePrototype clone() throws CloneNotSupportedException {
        System.out.println("具体的原型对象复制成功!");
        return (ShallowConcretePrototype) super.clone();
    }
}

