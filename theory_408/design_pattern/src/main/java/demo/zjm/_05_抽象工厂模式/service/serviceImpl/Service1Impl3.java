package demo.zjm._05_抽象工厂模式.service.serviceImpl;

import demo.zjm._05_抽象工厂模式.service.IService1;
import demo.zjm._05_抽象工厂模式.util.ResponseResult;

/**
 * @program: DesignPattern
 * @ClassName: YouKuMemberService
 * @description:
 * @author: AlanMa
 * @create: 2024-01-06 10:30
 */
public class Service1Impl3 implements IService1 {
    @Override
    public ResponseResult service() {
        return new ResponseResult("200","service3 succeed");
    }
}
