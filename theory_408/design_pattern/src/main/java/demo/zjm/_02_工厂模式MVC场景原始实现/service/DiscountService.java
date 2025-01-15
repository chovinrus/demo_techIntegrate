package demo.zjm._02_工厂模式MVC场景原始实现.service;

import demo.zjm._02_工厂模式MVC场景原始实现.util.ResponseResult;

/**
 * @program: DesignPattern
 * @ClassName: DiscountService
 * @description:
 * @author: AlanMa
 * @create: 2024-01-06 10:26
 */
public class DiscountService {
    public ResponseResult sendDiscount(String uid, String number){
        System.out.println("向用户发放打折券一张: " + uid + " , " + number);
        return new ResponseResult("200","发放打折券成功");
    }

}
