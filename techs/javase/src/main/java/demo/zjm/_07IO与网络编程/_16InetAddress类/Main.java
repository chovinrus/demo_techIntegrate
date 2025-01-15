package demo.zjm._07IO与网络编程._16InetAddress类;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) {
        try {
            InetAddress byAddress = InetAddress.getByName("192.168.0.104");
            System.out.println(byAddress);//    /192.168.0.104
            System.out.println(InetAddress.getByName("www.github.com"));//www.github.com/20.205.243.166
            System.out.println(InetAddress.getLocalHost());//Lindaiyv/192.168.81.1
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
