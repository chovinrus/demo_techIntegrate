package demo.zjm._05_抽象工厂模式.IOCContainer.IOCFactoryImpl;

import demo.zjm._05_抽象工厂模式.IOCContainer.IOCFactory;
import demo.zjm._05_抽象工厂模式.service.IService1;
import demo.zjm._05_抽象工厂模式.service.IService2;
import demo.zjm._05_抽象工厂模式.service.IService3;
import _05_抽象工厂模式.service.serviceImpl.*;
import demo.zjm._05_抽象工厂模式.service.serviceImpl.Group3Service1Impl;
import demo.zjm._05_抽象工厂模式.service.serviceImpl.Group3Service2Impl;
import demo.zjm._05_抽象工厂模式.service.serviceImpl.Group3Service3Impl;

/**
 * @program: DesignPattern
 * @ClassName: IOCFactory_ServiceImpl2
 * @description:
 * @author: AlanMa
 * @create: 2024-01-07 10:19
 */
public class IOCFactoryGroup3 implements IOCFactory {

    @Override
    public IService1 getService1() {
        return new Group3Service1Impl();
    }

    @Override
    public IService2 getService2() {
        return new Group3Service2Impl();
    }

    @Override
    public IService3 getService3() {
        return new Group3Service3Impl();
    }

}
