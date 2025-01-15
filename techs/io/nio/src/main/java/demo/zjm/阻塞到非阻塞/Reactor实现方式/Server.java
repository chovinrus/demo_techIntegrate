package demo.zjm.阻塞到非阻塞.Reactor实现方式;

import java.io.IOException;

/**
 * @program: demo_techIntegrate
 * @ClassName: Main
 * @description:
 * @author: AlanMa
 * @create: 2025-01-06 16:05
 */
public class Server {
    public static void main(String[] args) {
        try (Reactor reactor = new Reactor()) {
            reactor.run(); // 别开一个新线程跑，不然没法自动调用close方法
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
