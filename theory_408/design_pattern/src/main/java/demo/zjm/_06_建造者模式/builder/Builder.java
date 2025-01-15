package demo.zjm._06_建造者模式.builder;

import demo.zjm._06_建造者模式.product.Product;

/**
 * @program: DesignPattern
 * @ClassName: Builder
 * @description:
 * @author: AlanMa
 * @create: 2024-01-09 10:01
 */
public abstract class Builder {

    protected Product product = new Product();

    public abstract void buildComponent01();

    public abstract void buildComponent02();

    public abstract void buildComponent03();

    public Product getProduct(){
        return product;
    }
}
