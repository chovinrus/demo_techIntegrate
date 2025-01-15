package demo.zjm._03异常与泛型._01try_catch语句;

public class Main {
    public static void main(String[] args) {
        try {
            throw new ArrayIndexOutOfBoundsException();
            //Unreachable statement
            //System.out.println("---");
        } catch (NullPointerException e) {
            System.out.println("哈哈哈");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("略略略");
            //catch里面也可以有异常出现的
//            throw new ArrayIndexOutOfBoundsException();
        } catch (Exception e) {
            System.out.println("呜呜呜 ...");
            e.printStackTrace();
            e.getMessage();
        } finally {
            System.out.println("finally ..");
        }
        //略略略
        //finally ..
    }
}
