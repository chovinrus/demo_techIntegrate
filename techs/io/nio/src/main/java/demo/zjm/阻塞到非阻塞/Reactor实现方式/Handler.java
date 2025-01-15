package demo.zjm.阻塞到非阻塞.Reactor实现方式;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: demo_techIntegrate
 * @ClassName: Handler
 * @description:
 * @author: AlanMa
 * @create: 2025-01-06 15:09
 */
public class Handler implements Runnable {
    private final SocketChannel channel;

    public Handler(SocketChannel channel) {
        this.channel = channel;
    }


    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " >> handling request from " + channel.getRemoteAddress());
            // 处理请求
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            channel.read(buffer);
            buffer.flip();

            System.out.println("receive data: " + new String(buffer.array(), 0, buffer.remaining()));
            try {
                channel.write(ByteBuffer.wrap("response data".getBytes()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }



            // 处理完毕，关闭连接
            channel.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
