package demo.zjm._06_建造者模式.conductor;

import demo.zjm._06_建造者模式.builder.Builder;
import demo.zjm._06_建造者模式.product.Product;

/**
 * @program: DesignPattern
 * @ClassName: Conductor
 * @description:
 * @author: AlanMa
 * @create: 2024-01-09 18:41
 */

public class Conductor {
    private Builder builder;

    public Conductor(Builder builder) {
        this.builder = builder;
    }

    public Product construct(){
        builder.buildComponent01();
        builder.buildComponent02();
        builder.buildComponent03();
        return builder.getProduct();
    }
}
