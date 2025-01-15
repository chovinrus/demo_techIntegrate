package demo.zjm.阻塞到非阻塞.nio;

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
 * @create: 2025-01-06 08:27
 */
public class Client {
    public static void main(String[] args) {
        try (
                SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("localhost", 8080));
                Scanner scanner = new Scanner(System.in)
        ) {
            System.out.println("Connected to server");
            String message = "";
            while (!"quit".equals(message)) {
                System.out.println("Enter message to send to server:");
                message= scanner.nextLine();
                socketChannel.write(ByteBuffer.wrap(message.getBytes()));
                System.out.println("message sent to server..");
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                socketChannel.read(buffer);
                buffer.flip(); // read之后不要忘记flip，方便打印
                System.out.println(new String(buffer.array(), 0, buffer.remaining()));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
