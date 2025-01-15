package demo.zjm._02_工厂模式MVC场景原始实现.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * @program: DesignPattern
 * @ClassName: AwardInfo
 * @description:
 * @author: AlanMa
 * @create: 2024-01-06 09:51
 */
@Data
@Getter
public class AwardInfo {
    private String uid; //用户唯一ID
    private Integer awardType; //奖品类型: 1 打折券 ,2 优酷会员,3 小礼品
    private String awardNumber; //奖品编号
    Map<String, String> extMap; //额外信息

    public String getUid() {
        return uid;
    }

    public Integer getAwardType() {
        return awardType;
    }

    public String getAwardNumber() {
        return awardNumber;
    }

    public Map<String, String> getExtMap() {
        return extMap;
    }
}
