package demo.zjm._07IO与网络编程._01File对象;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/_07IO与网络编程/_01File对象/resource.properties");
//        file = new File("src/_07IO与网络编程/_01File对象", "resource.properties");
//        file = new File(new File("src/_07IO与网络编程/_01File对象"), "resource.properties");
//        System.out.println(file);
//        file = new File("src" + File.separator + "_07IO与网络编程" + File.separator
//                + "_01File对象" + File.separator + "resource.properties");
    }
}
