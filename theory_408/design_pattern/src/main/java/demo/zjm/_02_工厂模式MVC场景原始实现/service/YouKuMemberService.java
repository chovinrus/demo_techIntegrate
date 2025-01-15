package demo.zjm._02_工厂模式MVC场景原始实现.service;

import demo.zjm._02_工厂模式MVC场景原始实现.util.ResponseResult;

/**
 * @program: DesignPattern
 * @ClassName: YouKuMemberService
 * @description:
 * @author: AlanMa
 * @create: 2024-01-06 10:30
 */
public class YouKuMemberService {

    public ResponseResult openMember(String bindMobile , String number){
        System.out.println("发放优酷会员: " + bindMobile + " , " + number);
        return new ResponseResult("200","发放优酷会员成功");
    }

}
