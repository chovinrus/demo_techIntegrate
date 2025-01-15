package demo.zjm._07_建造者模式实现不可变对象.client;

import demo.zjm._07_建造者模式实现不可变对象.target.Product;

/**
 * @program: DesignPattern
 * @ClassName: Client
 * @description:
 * @author: AlanMa
 * @create: 2024-01-10 10:37
 */
public class Client {
    public static void main(String[] args) {
        Product product = new Product
                .Builder()
                .setComponent1("component1")
                .setComponent2("component2")
                .setComponent3("component3")
                .build();
        System.out.println(product);//Product{component1='component1', component2='component2', component3='component3'}
        System.out.println(LombokBuilderProduct.builder().getClass());//class _07_建造者模式实现链式编程.client.LombokBuilderProduct$LombokBuilderProductBuilder
        LombokBuilderProduct obj = LombokBuilderProduct.builder().component1("1").build();
        System.out.println(obj);//LombokBuilderProduct(component1=1)
    }

}
