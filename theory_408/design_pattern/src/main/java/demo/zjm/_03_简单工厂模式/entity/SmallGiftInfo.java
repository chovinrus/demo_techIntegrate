package demo.zjm._03_简单工厂模式.entity;

import lombok.Data;

/**
 * @program: DesignPattern
 * @ClassName: SmallGiftInfo
 * @description:
 * @author: AlanMa
 * @create: 2024-01-06 09:52
 */
@Data
public class SmallGiftInfo {
    private String userName; // 用户姓名
    private String userPhone; // 用户手机
    private String orderId; // 订单ID
    private String relAddress; // 收货地址
}
