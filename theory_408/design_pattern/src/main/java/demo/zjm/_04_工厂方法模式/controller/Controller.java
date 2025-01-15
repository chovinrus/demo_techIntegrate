package demo.zjm._04_工厂方法模式.controller;

import demo.zjm._05_抽象工厂模式.IOCContainer.IOCFactory;
import demo.zjm._05_抽象工厂模式.IOCContainer.IOCFactoryImpl.IOCFactoryGroup1;
import demo.zjm._05_抽象工厂模式.IOCContainer.IOCFactoryImpl.IOCFactoryGroup3;
import demo.zjm._05_抽象工厂模式.IOCContainer.IOCFactoryImpl.IOCFactoryGroup2;
import demo.zjm._05_抽象工厂模式.service.IService1;
import demo.zjm._05_抽象工厂模式.util.ResponseResult;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: DesignPattern
 * @ClassName: DeliverController
 * @description:
 * @author: AlanMa
 * @create: 2024-01-06 11:46
 */
public class Controller {
    private static final Map<String, IOCFactory> IOC_FACTORY_MAP = new HashMap<>();

    static {
        IOC_FACTORY_MAP.put("serviceImpl1", new IOCFactoryGroup1());
        IOC_FACTORY_MAP.put("serviceImpl2", new IOCFactoryGroup3());
        IOC_FACTORY_MAP.put("serviceImpl3", new IOCFactoryGroup2());
    }

    IOCFactory iocFactory;

    IService1 service;

    public ResponseResult handleRequest(String requestPattern) {
        // 这两步本是SpringIOC中自动完成的动作，即autowire注解完成的动作
        iocFactory = IOC_FACTORY_MAP.get(requestPattern);
        service = iocFactory.getService1();

        ResponseResult resResult = service.service();
        return resResult;
    }
}
