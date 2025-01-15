package demo.zjm._02面向对象._02super关键字;

public class Main extends Base {

    public Main() {

    }

    public static void main(String[] args) {
        Main main = new Main();//Base is Constructing..
        Base base = new Main();
        //base.fun();   //Cannot resolve method 'fun' in 'Base'
    }

    void fun() {

    }
}
