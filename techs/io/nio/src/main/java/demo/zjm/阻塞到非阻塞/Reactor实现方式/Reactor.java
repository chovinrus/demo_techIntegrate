package demo.zjm.阻塞到非阻塞.Reactor实现方式;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @program: demo_techIntegrate
 * @ClassName: Reactor
 * @description:
 * @author: AlanMa
 * @create: 2025-01-06 15:09
 */
public class Reactor implements Closeable, Runnable {

    private final Selector selector;
    private final ServerSocketChannel serverSocketChannel;

    public Reactor() throws IOException {
        this.selector = Selector.open();
        this.serverSocketChannel = ServerSocketChannel.open();
    }

    // Closable接口继承自AutoCloseable接口，实现了close方法，用于关闭资源
    @Override
    public void close() throws IOException {
        serverSocketChannel.close();
        selector.close();
    }

    @Override
    public void run() {
        try {
            serverSocketChannel.bind(new InetSocketAddress(8080));
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT, new Acceptor(serverSocketChannel)); // 注册到selector

            // 为实现非阻塞，需要循环处理selector的事件
            while (true) {
                // 等待accept事件发生，返回值为监听到的事件数
                int count = selector.select();
                // 处理事件
                Set<SelectionKey> selectionKeys = selector.selectedKeys(); // Key就是事件的对象
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    dispatch(iterator.next());
                    iterator.remove();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void dispatch(SelectionKey key) { //key是监听到的事件对象
        Object att = key.attachment(); //attachment是绑定的事件处理器
        if (att instanceof Runnable) {
            ((Runnable) att).run();
        }
    }
}
