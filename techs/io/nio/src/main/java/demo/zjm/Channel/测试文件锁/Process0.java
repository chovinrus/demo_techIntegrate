package demo.zjm.Channel.测试文件锁;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Date;
import java.util.concurrent.locks.Lock;

/**
 * @program: demo_techIntegrate
 * @ClassName: Main
 * @description:
 * @author: AlanMa
 * @create: 2025-01-01 21:53
 */
public class Process0 {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Process0 进程加独占锁，加锁文件段为0-4字节
        try (
                RandomAccessFile raf = new RandomAccessFile("test.txt", "rw");
                FileChannel channel = raf.getChannel();){
            FileLock lock = channel.lock(0, 5, false); //加锁，true表示共享锁
            System.out.println(new Date() + "Process1 获得文件独占锁");
            channel.read(ByteBuffer.allocate(5), 0); //读取5字节
            Thread.sleep(10000);
            System.out.println(new Date() + "操作完毕，释放文件锁");
            lock.release(); //释放锁
        }
    }
}
