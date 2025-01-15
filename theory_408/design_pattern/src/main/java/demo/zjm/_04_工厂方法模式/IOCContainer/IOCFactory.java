package demo.zjm._04_工厂方法模式.IOCContainer;

import demo.zjm._04_工厂方法模式.service.IService;

public interface IOCFactory {
    IService getInstance();
}
