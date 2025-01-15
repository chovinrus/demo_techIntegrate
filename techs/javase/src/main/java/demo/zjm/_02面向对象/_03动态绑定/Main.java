package demo.zjm._02面向对象._03动态绑定;

class Base {
  int field1 = 0;
  void fun(){
    System.out.println("Base is funning..");
  }
}
class Sub extends Base{
  int field1 = 1;
  void fun(){
    System.out.println("Sub is funning..");
  }
}
public class Main {
  public static void main(String[] args) {
    Base base = new Sub();
    base.fun(); //Sub is funning..
    System.out.println(base.field1); //0
  }
}
