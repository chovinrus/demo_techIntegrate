package demo.zjm._07IO与网络编程._18UDP编程;

//import com.sun.xml.internal.ws.api.message.Packet;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Main {

    public static void main(String[] args) {

    }

    @Test
    public void sender() {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();
            DatagramPacket packet =
                    new DatagramPacket("Hello".getBytes(), 0, "Hello".getBytes().length,
                            InetAddress.getLocalHost(), 4112);
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }

    @Test
    public void receiver() {
        DatagramSocket socket = null;
        DatagramPacket packet = null;
        try {
            socket = new DatagramSocket(4112);
            packet = new DatagramPacket(new byte[128], 0, new byte[128].length);
            socket.receive(packet);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println(new String(packet.getData(), 0, packet.getLength()));
            if (socket != null) {
                socket.close();
            }
        }
    }
}
