package demo.zjm._03_简单工厂模式.service.serviceImpl;

import demo.zjm._03_简单工厂模式.entity.AwardInfo;
import demo.zjm._03_简单工厂模式.service.IFreeGoods;
import demo.zjm._03_简单工厂模式.util.ResponseResult;

/**
 * @program: DesignPattern
 * @ClassName: YouKuMemberService
 * @description:
 * @author: AlanMa
 * @create: 2024-01-06 10:30
 */

public class YouKuMemberFreeGoods implements IFreeGoods {
    @Override
    public ResponseResult sendFreeGoods(AwardInfo awardInfo) {
        String phone = awardInfo.getExtMap().get("phone");
        System.out.println("发放优酷会员成功,绑定手机号: " + phone);
        return new ResponseResult("200","优酷会员发放成功!");
    }
}
