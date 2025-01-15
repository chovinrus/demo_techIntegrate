package demo.zjm.阻塞到非阻塞.Reactor实现方式;

import java.io.IOException;
import java.nio.channels.*;

/**
 * @program: demo_techIntegrate
 * @ClassName: Accpter
 * @description:
 * @author: AlanMa
 * @create: 2025-01-06 15:09
 */
public class Acceptor implements Runnable {

    private final ServerSocketChannel serverSocketChannel;

    public Acceptor(ServerSocketChannel serverSocketChannel) {
        this.serverSocketChannel = serverSocketChannel;
    }

    @Override
    public void run() {
        try {
            SocketChannel socketChannel = serverSocketChannel.accept();// 接收客户端连接，返回SocketChannel对象
            System.out.println(Thread.currentThread().getName() + " >> new connection from socketChannel: " + socketChannel.getRemoteAddress());
            System.out.println("client connected: " + socketChannel.getRemoteAddress());
            socketChannel.configureBlocking(false); // 为socketChannel设置非阻塞模式
            Selector selector = SubReactor.nextSelector();
            selector.wakeup(); // 唤醒selector
            socketChannel.register(selector, SelectionKey.OP_READ, new Handler(socketChannel)); // 注册到selector，监听读事件
        } catch (ClosedChannelException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
