package demo.zjm.代理模式._03动态代理;

public class Implement1 implements Interface {
    int num;

    @Override
    public String function(Integer num) {
        System.out.println("Impl1's funtion ..");
        this.num = num;
        return num.toString();
    }
}
