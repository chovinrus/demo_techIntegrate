package demo.zjm._07_建造者模式实现不可变对象.client;

import lombok.Builder;
import lombok.Data;

/**
 * @program: DesignPattern
 * @ClassName: LombokBuilder
 * @description:
 * @author: AlanMa
 * @create: 2024-01-11 18:19
 */
@Builder
@Data
public class LombokBuilderProduct {
    String component1;
}
