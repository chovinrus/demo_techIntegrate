package demo.zjm._03_简单工厂模式.controller;

import demo.zjm._03_简单工厂模式.IOCContainer.FreeGoodsFactory;
import demo.zjm._03_简单工厂模式.entity.AwardInfo;
import demo.zjm._03_简单工厂模式.service.IFreeGoods;
import demo.zjm._03_简单工厂模式.util.ResponseResult;

/**
 * @program: DesignPattern
 * @ClassName: DeliverController
 * @description:
 * @author: AlanMa
 * @create: 2024-01-06 11:46
 */
public class DeliverController {
    public ResponseResult awardToUser(AwardInfo awardInfo) {
        try {
            IFreeGoods freeGoods =
                    FreeGoodsFactory.getInstance(awardInfo.getAwardType());
            ResponseResult responseResult = freeGoods.sendFreeGoods(awardInfo);
            return responseResult;
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseResult("201", "奖品发放失败!");
        }
    }
}
