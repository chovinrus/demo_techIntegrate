package demo.zjm._01Java语言基础._10标签跳转语句;

public class Main {
    public static void main(String[] args) {
//        out:
//        while (true) {
//            System.out.println("out..");
//            in:
//            while (true) {
//                System.out.println("in..");
//                continue out;
//            }
//            //Unreachable statement
//            //System.out.println("");
//        }

        label:
        {
            System.out.println("1");
            break label;
            //Unreachable statement
            //System.out.println("1");
        }

    }
}
