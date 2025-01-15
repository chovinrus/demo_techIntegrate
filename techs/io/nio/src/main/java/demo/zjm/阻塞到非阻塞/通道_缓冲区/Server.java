package demo.zjm.阻塞到非阻塞.通道_缓冲区;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @program: demo_techIntegrate
 * @ClassName: Server
 * @description:
 * @author: AlanMa
 * @create: 2025-01-04 13:37
 */
public class Server {
    public static void main(String[] args) {
        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()){
            int port = 8080;
            serverSocketChannel.bind(new InetSocketAddress(port));

            SocketChannel socketChannel = serverSocketChannel.accept();
            System.out.println("client connected: " + socketChannel.getRemoteAddress());

            // 读取数据
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            socketChannel.read(byteBuffer);
            byteBuffer.flip();
            System.out.println("receive message: " + new String(byteBuffer.array(), 0, byteBuffer.remaining()));

            // 返回确认消息
            String response = "server received your message..";
            byte[] bytes = response.getBytes();
            ByteBuffer writeBuffer = ByteBuffer.wrap(bytes);
            socketChannel.write(writeBuffer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
