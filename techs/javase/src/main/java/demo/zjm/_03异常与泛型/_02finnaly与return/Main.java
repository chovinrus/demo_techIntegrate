package demo.zjm._03异常与泛型._02finnaly与return;

public class Main {
    public static void main(String[] args) {
        System.out.println(test());}
    static String test(){
        try {
            //会执行，但是拿到返回值是在finally执行完成后
            //return "try return";
            //测试catch中的return
            throw new Exception();
        } catch (Exception e) {
            //会执行，但是拿到返回值是在finally执行完成后
            //return "catch return";
        } finally {
            System.out.println("finally ..");
            return "final return";
        }
    }
}
