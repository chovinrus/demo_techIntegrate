package demo.zjm._02_工厂模式MVC场景原始实现.service;


import demo.zjm._02_工厂模式MVC场景原始实现.entity.SmallGiftInfo;
import com.alibaba.fastjson.JSON;

/**
 * @program: DesignPattern
 * @ClassName: SmallGiftService
 * @description:
 * @author: AlanMa
 * @create: 2024-01-06 10:32
 */
public class SmallGiftService {
    public Boolean giveSmallGift(SmallGiftInfo smallGiftInfo){
        System.out.println("小礼品已发货,获奖用户注意查收! " +
                JSON.toJSON(smallGiftInfo));
        return true;
    }
}
