package demo.zjm.阻塞到非阻塞.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @program: demo_techIntegrate
 * @ClassName: Server
 * @description:
 * @author: AlanMa
 * @create: 2025-01-06 08:27
 */
public class Server {
    public static void main(String[] args) {
        try (
                ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
                Selector selector = Selector.open();
        ) {
            serverSocketChannel.bind(new InetSocketAddress(8080));
            serverSocketChannel.configureBlocking(false); // 设置非阻塞模式
            // selector监听的事件，有四种：可以用|连接，并不是所有的Channel都支持所有的事件
            // public static final int OP_READ = 1 << 0; // 读就绪
            // public static final int OP_WRITE = 1 << 2; // 写就绪，其实这个事件比较特殊，是己方主动控制的，不需要selector监听
            // public static final int OP_CONNECT = 1 << 3; // 连接到服务器就绪
            // public static final int OP_ACCEPT = 1 << 4; // 接收客户端连接就绪
            // 当匹配上的时候
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT); // 注册到selector
            // 为实现非阻塞，需要循环处理selector的事件
            while (true) {
                // 等待accept事件发生，返回值为监听到的事件数
                int count = selector.select();
                // 处理事件
                Set<SelectionKey> selectionKeys = selector.selectedKeys(); // Key就是事件的对象
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    if (key.isAcceptable()) { // 接收客户端连接
                        SocketChannel socketChannel = serverSocketChannel.accept();// 接收客户端连接，返回SocketChannel对象
                        System.out.println("client connected: " + socketChannel.getRemoteAddress());
                        socketChannel.configureBlocking(false); // 为socketChannel设置非阻塞模式
                        socketChannel.register(selector, SelectionKey.OP_READ); // 注册到selector，监听读事件
                    } else if (key.isReadable()) { // 读事件
                        // 从读事件对象中获取SocketChannel对象
                        SocketChannel channel = (SocketChannel) key.channel();
                        // 读取数据到buffer中
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        channel.read(buffer);
                        buffer.flip();
                        System.out.println("receive message: " + new String(buffer.array(), 0, buffer.remaining()));
                        buffer.flip();
                        // 写确认消息到客户端
                        channel.write(ByteBuffer.wrap("message received.. ".getBytes()));
                    }
                    iterator.remove(); // 处理完事件，从集合中移除
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
