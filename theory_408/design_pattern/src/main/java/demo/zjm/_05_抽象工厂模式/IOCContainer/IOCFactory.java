package demo.zjm._05_抽象工厂模式.IOCContainer;

import demo.zjm._05_抽象工厂模式.service.IService1;
import demo.zjm._05_抽象工厂模式.service.IService2;
import demo.zjm._05_抽象工厂模式.service.IService3;

public interface IOCFactory {
    IService1 getService1();
    IService2 getService2();
    IService3 getService3();


}
