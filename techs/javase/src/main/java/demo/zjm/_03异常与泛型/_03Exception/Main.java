package demo.zjm._03异常与泛型._03Exception;

public class Main {
    public static void main(String[] args) {
        try {
            throw new ArrayIndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            //null
            //java.lang.ArrayIndexOutOfBoundsException
            //	at _04Exception类.a.Main.main(a.Main.java:6)
        }
    }
}
