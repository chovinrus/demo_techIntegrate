package demo.zjm._08反射._16动态代理;

public class Implement2 implements Interface {
    int num;

    @Override
    public String function(Integer num) {
        System.out.println("Impl2's funtion ..");
        this.num = num;
        return num.toString();
    }
}
