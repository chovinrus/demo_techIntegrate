package demo.zjm._06集合._14Properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

class x {
}

class c {
}

public class Main {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/_06集合/_14Properties/xxx.properties");
        Properties properties = new Properties();
        properties.load(fileInputStream);
        String name = properties.getProperty("name");
        String password = properties.getProperty("password");
        System.out.println(name + " " + password);
        //"zjm" "88888888"
        fileInputStream.close();
    }
}
