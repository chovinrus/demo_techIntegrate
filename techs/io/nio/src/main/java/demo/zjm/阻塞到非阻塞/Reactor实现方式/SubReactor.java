package demo.zjm.阻塞到非阻塞.Reactor实现方式;

import java.io.Closeable;
import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: demo_techIntegrate
 * @ClassName: SubReactor
 * @description:
 * @author: AlanMa
 * @create: 2025-01-06 23:10
 */
public class SubReactor implements Runnable, Closeable {

    private static final ExecutorService POOL = Executors.newFixedThreadPool(4);
    private static final SubReactor[] reactors = new SubReactor[4];
    private static int selectorIndex = 0;

    // 初始化selector并启动线程
    static {
        for (int i = 0; i < 4; i++) {
            try {
                reactors[i] = new SubReactor();
                POOL.submit(reactors[i]);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private final Selector selector;//每个从Selector有一个Selector

    public SubReactor() throws IOException {
        selector = Selector.open();
    }

    public static Selector nextSelector() {
        Selector selector = reactors[selectorIndex].selector;
        selectorIndex = (selectorIndex + 1) % 4;
        return selector;
    }

    @Override
    public void close() throws IOException {
        selector.close();
    }

    @Override
    public void run() {
        try {   //启动后直接等待selector监听到对应的事件即可，其他的操作逻辑和Reactor一致
            while (true) {
                int count = selector.select();
                //System.out.println(Thread.currentThread().getName()+count);
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    this.dispatch(iterator.next());
                    iterator.remove();
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }




    private void dispatch(SelectionKey key) { //key是监听到的事件对象
        Object att = key.attachment(); //attachment是绑定的事件处理器
        if (att instanceof Runnable) {
            ((Runnable) att).run();
        }
    }
}

