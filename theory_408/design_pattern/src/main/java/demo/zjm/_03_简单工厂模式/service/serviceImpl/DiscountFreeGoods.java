package demo.zjm._03_简单工厂模式.service.serviceImpl;


import demo.zjm._03_简单工厂模式.entity.AwardInfo;
import demo.zjm._03_简单工厂模式.service.IFreeGoods;
import demo.zjm._03_简单工厂模式.util.ResponseResult;
import lombok.Data;

/**
 * @program: DesignPattern
 * @ClassName: DiscountService
 * @description:
 * @author: AlanMa
 * @create: 2024-01-06 10:26
 */
@Data
public class DiscountFreeGoods implements IFreeGoods {
    @Override
    public ResponseResult sendFreeGoods(AwardInfo awardInfo) {
        System.out.println("向用户发放打折券一张: " + awardInfo.getUid() + " , " + awardInfo.getAwardNumber());
        return new ResponseResult("200","发放打折券成功");
    }
}
