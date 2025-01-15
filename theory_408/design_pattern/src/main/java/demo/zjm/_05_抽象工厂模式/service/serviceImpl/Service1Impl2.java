package demo.zjm._05_抽象工厂模式.service.serviceImpl;

import demo.zjm._05_抽象工厂模式.service.IService1;
import demo.zjm._05_抽象工厂模式.util.ResponseResult;

/**
 * @program: DesignPattern
 * @ClassName: SmallGiftService
 * @description:
 * @author: AlanMa
 * @create: 2024-01-06 10:32
 */
public class Service1Impl2 implements IService1 {

    @Override
    public ResponseResult service() {
        return new ResponseResult("200","service2 succeed");
    }
}
