package demo.zjm._04_工厂方法模式.service.serviceImpl;


import demo.zjm._04_工厂方法模式.service.IService;
import demo.zjm._04_工厂方法模式.util.ResponseResult;
import lombok.Data;

/**
 * @program: DesignPattern
 * @ClassName: DiscountService
 * @description:
 * @author: AlanMa
 * @create: 2024-01-06 10:26
 */
@Data
public class ServiceImpl1 implements IService { @Override
    public ResponseResult service() {
        return new ResponseResult("200","service1 succeed");
    }
}
