package demo.zjm._03_简单工厂模式.IOCContainer;

import demo.zjm._03_简单工厂模式.service.serviceImpl.DiscountFreeGoods;
import demo.zjm._03_简单工厂模式.service.IFreeGoods;
import demo.zjm._03_简单工厂模式.service.serviceImpl.SmallGiftFreeGoods;
import demo.zjm._03_简单工厂模式.service.serviceImpl.YouKuMemberFreeGoods;

/**
 * @program: DesignPattern
 * @ClassName: FreeGoodsFactory
 * @description:
 * @author: AlanMa
 * @create: 2024-01-06 16:04
 */
public class FreeGoodsFactory {

    public static IFreeGoods getInstance(Integer awardType){
        IFreeGoods iFreeGoods = null;
        if(awardType == 1){ //打折券
            iFreeGoods = new DiscountFreeGoods();
        }else if(awardType == 2){ //优酷会员
            iFreeGoods = new YouKuMemberFreeGoods();
        }else if(awardType == 3){ //小礼品
            iFreeGoods = new SmallGiftFreeGoods();
        }
        return iFreeGoods;
    }

}
