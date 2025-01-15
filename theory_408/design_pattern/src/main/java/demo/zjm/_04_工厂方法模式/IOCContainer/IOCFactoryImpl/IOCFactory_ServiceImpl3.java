package demo.zjm._04_工厂方法模式.IOCContainer.IOCFactoryImpl;

import demo.zjm._04_工厂方法模式.IOCContainer.IOCFactory;
import demo.zjm._04_工厂方法模式.service.IService;
import demo.zjm._04_工厂方法模式.service.serviceImpl.ServiceImpl3;

/**
 * @program: DesignPattern
 * @ClassName: IOCFactory_ServiceImpl3
 * @description:
 * @author: AlanMa
 * @create: 2024-01-07 10:19
 */
public class IOCFactory_ServiceImpl3 implements IOCFactory {
    public IService getInstance(){
        IService service = new ServiceImpl3();
        return service;
    }
}
