package demo.zjm.代理模式._03动态代理;

public class Implement2 implements Interface {
    int num;

    @Override
    public String function(Integer num) {
        System.out.println("Impl2's funtion ..");
        this.num = num;
        return num.toString();
    }
}
