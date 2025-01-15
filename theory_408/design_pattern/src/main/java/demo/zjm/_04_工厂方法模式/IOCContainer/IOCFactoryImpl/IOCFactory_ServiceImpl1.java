package demo.zjm._04_工厂方法模式.IOCContainer.IOCFactoryImpl;

import demo.zjm._04_工厂方法模式.IOCContainer.IOCFactory;
import demo.zjm._04_工厂方法模式.service.IService;
import demo.zjm._04_工厂方法模式.service.serviceImpl.ServiceImpl1;

/**
 * @program: DesignPattern
 * @ClassName: FreeGoodsFactory
 * @description:
 * @author: AlanMa
 * @create: 2024-01-06 16:04
 */
public class IOCFactory_ServiceImpl1 implements IOCFactory {

    public IService getInstance(){
        IService service = new ServiceImpl1();
        return service;
    }

}
