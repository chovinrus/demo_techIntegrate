package demo.zjm._05_抽象工厂模式.IOCContainer.IOCFactoryImpl;

import demo.zjm._05_抽象工厂模式.IOCContainer.IOCFactory;
import demo.zjm._05_抽象工厂模式.service.IService1;
import demo.zjm._05_抽象工厂模式.service.IService2;
import demo.zjm._05_抽象工厂模式.service.IService3;
import demo.zjm._05_抽象工厂模式.service.serviceImpl.Group1Service1Impl;
import demo.zjm._05_抽象工厂模式.service.serviceImpl.Group1Service2Impl;
import demo.zjm._05_抽象工厂模式.service.serviceImpl.Group1Service3Impl;

/**
 * @program: DesignPattern
 * @ClassName: FreeGoodsFactory
 * @description:
 * @author: AlanMa
 * @create: 2024-01-06 16:04
 */
public class IOCFactoryGroup1 implements IOCFactory {

    @Override
    public IService1 getService1() {
        return new Group1Service1Impl();
    }

    @Override
    public IService2 getService2() {
        return new Group1Service2Impl();
    }

    @Override
    public IService3 getService3() {
        return new Group1Service3Impl();
    }
}
