package demo.zjm._05_抽象工厂模式.controller;

import demo.zjm._05_抽象工厂模式.IOCContainer.IOCFactory;
import demo.zjm._05_抽象工厂模式.IOCContainer.IOCFactoryImpl.IOCFactoryGroup1;
import demo.zjm._05_抽象工厂模式.IOCContainer.IOCFactoryImpl.IOCFactoryGroup3;
import demo.zjm._05_抽象工厂模式.IOCContainer.IOCFactoryImpl.IOCFactoryGroup2;
import demo.zjm._05_抽象工厂模式.service.IService2;
import demo.zjm._05_抽象工厂模式.util.ResponseResult;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
        IOC_FACTORY_MAP.put("iocFactory1", new IOCFactoryGroup1());
        IOC_FACTORY_MAP.put("iocFactory2", new IOCFactoryGroup2());
        IOC_FACTORY_MAP.put("iocFactory3", new IOCFactoryGroup3());
    }

    IOCFactory iocFactory;

    IService2 service;

    public ResponseResult handleRequest(String requestPattern) {
        String groupName = requestPattern.split("_")[0];
        String serviceName = requestPattern.split("_")[1];

        // 这两步本是SpringIOC中自动完成的动作，即autowire注解完成的动作
        iocFactory = IOC_FACTORY_MAP.get(groupName);
        try {
            Method getServiceMethod = iocFactory.getClass().getDeclaredMethod("get" + serviceName);
            getServiceMethod.setAccessible(true);
            service = (IService2) getServiceMethod.invoke(iocFactory);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        ResponseResult resResult = service.service();
        return resResult;
    }

    @Test
    public void test(){
        Controller controller = new Controller();
        ResponseResult responseResult = controller.handleRequest("iocFactory3" + "_" + "Service2");
        System.out.println(responseResult);
    }
}
