package demo.zjm.Channel.测试文件锁;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Date;

/**
 * @program: demo_techIntegrate
 * @ClassName: Process
 * @description:
 * @author: AlanMa
 * @create: 2025-01-01 21:56
 */
public class Process1 {
    public static void main(String[] args){
        // Process0 进程加独占锁，加锁文件段为5-9字节
        try (
                RandomAccessFile raf = new RandomAccessFile("test.txt", "rw");
                FileChannel channel = raf.getChannel();){
                FileLock lock = channel.tryLock(4, 9, true); //加锁，true表示共享锁
            System.out.println(new Date() + "Process1 获得文件独占锁");
            channel.read(ByteBuffer.allocate(5),4);
            Thread.sleep(5000);
            System.out.println(new Date() + "操作完毕，释放文件锁");
            lock.release(); //释放锁
        } catch (IOException e) {
            System.out.println("Process1 异常：" + e.getMessage());
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
