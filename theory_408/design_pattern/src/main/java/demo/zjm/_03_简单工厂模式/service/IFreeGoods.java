package demo.zjm._03_简单工厂模式.service;

import demo.zjm._03_简单工厂模式.entity.AwardInfo;
import demo.zjm._03_简单工厂模式.util.ResponseResult;

public interface IFreeGoods {
    /**
     *  service interace
     * @param awardInfo
     * @return _03_简单工厂模式.util.ResponseResult
     * @author 26973
     * @date 2024/1/6 12:55
    **/
    ResponseResult sendFreeGoods(AwardInfo awardInfo);
}
