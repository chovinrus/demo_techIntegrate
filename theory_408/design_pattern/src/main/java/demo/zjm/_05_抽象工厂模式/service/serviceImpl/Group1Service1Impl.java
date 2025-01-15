package demo.zjm._05_抽象工厂模式.service.serviceImpl;


import demo.zjm._05_抽象工厂模式.service.IService1;
import demo.zjm._05_抽象工厂模式.util.ResponseResult;
import lombok.Data;

/**
 * @program: DesignPattern
 * @ClassName: DiscountService
 * @description:
 * @author: AlanMa
 * @create: 2024-01-06 10:26
 */
@Data
public class Group1Service1Impl implements IService1 {
    @Override
    public ResponseResult service() {
        return new ResponseResult("200", "Group1Service1Impl is servicing");
    }
}
