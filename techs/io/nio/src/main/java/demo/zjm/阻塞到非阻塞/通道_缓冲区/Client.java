package demo.zjm.阻塞到非阻塞.通道_缓冲区;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * @program: demo_techIntegrate
 * @ClassName: Client
 * @description:
 * @author: AlanMa
 * @create: 2025-01-04 13:37
 */
public class Client {
    public static void main(String[] args) {

        try(
            SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("localhost", 8080));
            Scanner scanner = new Scanner(System.in)
        ){
            //连接到服务器
            System.out.println("has connected to server ..");

            //发送消息到服务器
            System.out.println("please input message to send to server:");
            String message = scanner.nextLine();
            socketChannel.write(ByteBuffer.wrap(message.getBytes()));

            ByteBuffer buffer = ByteBuffer.allocate(1024);
            socketChannel.read(buffer);
            buffer.flip();
            System.out.println("receive message from server: " + new String(buffer.array(), 0, buffer.remaining()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
