package demo.zjm._08反射._05读取配置文件;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStream resourceAsStream =
                Main.class.getClassLoader().getResourceAsStream("demo/zjm/_08反射/_05读取配置文件/jdbc.properties");
        System.out.println(resourceAsStream);
        //java.io.BufferedInputStream@1b6d3586
        Properties properties = new Properties();
        properties.load(resourceAsStream);
        String user = properties.getProperty("user");
        System.out.println(user);
        //root
    }
}
