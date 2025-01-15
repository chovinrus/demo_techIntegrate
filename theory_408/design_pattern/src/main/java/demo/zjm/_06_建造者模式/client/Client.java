package demo.zjm._06_建造者模式.client;

import demo.zjm._06_建造者模式.builder.builderImpl.Builder01;
import demo.zjm._06_建造者模式.conductor.Conductor;
import demo.zjm._06_建造者模式.product.Product;

/**
 * @program: DesignPattern
 * @ClassName: Client
 * @description:
 * @author: AlanMa
 * @create: 2024-01-09 10:02
 */
public class Client {
    public static void main(String[] args) {
        Conductor conductor = new Conductor(new Builder01());
        Product product = conductor.construct();
        System.out.println(product);
    }
}
