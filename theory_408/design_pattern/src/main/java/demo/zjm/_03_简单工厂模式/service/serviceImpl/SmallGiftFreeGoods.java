package demo.zjm._03_简单工厂模式.service.serviceImpl;

import demo.zjm._03_简单工厂模式.entity.AwardInfo;
import demo.zjm._03_简单工厂模式.entity.SmallGiftInfo;
import demo.zjm._03_简单工厂模式.service.IFreeGoods;
import demo.zjm._03_简单工厂模式.util.ResponseResult;
import com.alibaba.fastjson.JSON;

import java.util.UUID;

/**
 * @program: DesignPattern
 * @ClassName: SmallGiftService
 * @description:
 * @author: AlanMa
 * @create: 2024-01-06 10:32
 */
public class SmallGiftFreeGoods implements IFreeGoods {

    @Override
    public ResponseResult sendFreeGoods(AwardInfo awardInfo) {
        SmallGiftInfo smallGiftInfo = new SmallGiftInfo();
        smallGiftInfo.setUserPhone(awardInfo.getExtMap().get("phone"));
        smallGiftInfo.setUserName(awardInfo.getExtMap().get("username"));
        smallGiftInfo.setRelAddress(awardInfo.getExtMap().get("address"));
        smallGiftInfo.setOrderId(UUID.randomUUID().toString());
        System.out.println("小礼品发放成,请注意查收: " + JSON.toJSON(smallGiftInfo));
        return new ResponseResult("200","小礼品发送成功",smallGiftInfo);
    }
}
