package demo.zjm._06_建造者模式.builder.builderImpl;

import demo.zjm._06_建造者模式.builder.Builder;

/**
 * @program: DesignPattern
 * @ClassName: Comnent01Builder
 * @description:
 * @author: AlanMa
 * @create: 2024-01-09 20:50
 */
public class Builder03 extends Builder {
    @Override
    public void buildComponent01() {
        product.setComponet1("builder03's component1");
    }

    @Override
    public void buildComponent02() {
        product.setComponet2("builder03's component2");
    }

    @Override
    public void buildComponent03() {
        product.setComponet3("builder03's component3");
    }
}
