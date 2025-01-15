package demo.zjm._04_工厂方法模式.service.serviceImpl;

import demo.zjm._04_工厂方法模式.service.IService;
import demo.zjm._04_工厂方法模式.util.ResponseResult;

/**
 * @program: DesignPattern
 * @ClassName: YouKuMemberService
 * @description:
 * @author: AlanMa
 * @create: 2024-01-06 10:30
 */
public class ServiceImpl3 implements IService {
    @Override
    public ResponseResult service() {
        return new ResponseResult("200","service3 succeed");
    }
}
