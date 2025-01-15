package demo.zjm.Channel;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.ReadableByteChannel;
import java.util.Arrays;

/**
 * @program: demo_techIntegrate
 * @ClassName: Main
 * @description:
 * @author: AlanMa
 * @create: 2024-12-27 10:56
 */
public class Main {
    public static void main(String[] args) throws IOException {
        //// 传统IO读取数据
        //byte[] data = new byte[1024];
        //InputStream in = System.in;
        //c: while (true){
        //    int len;
        //    String str;
        //    while ((len = in.read(data)) > 0){
        //        System.out.println("读取到一批数据：" + (str = new String(data, 0, len)));
        //        if (str.equals("exit\n")) break c;
        //    }
        //}


    //    ByteBuffer buffer = ByteBuffer.allocate(1024);
    //    //将System.in作为输入源
    //    ReadableByteChannel readChannel = Channels.newChannel(System.in);
    //    c : while (true) {
    //        String str;
    //        readChannel.read(buffer);
    //        buffer.flip();
    //        System.out.println("读取到一批数据：" + (str = new String(buffer.array(), 0, buffer.remaining())));
    //        buffer.clear();
    //        if (str.equals("exit\n")) break c;
    //    }

        //// 文件io
        //new File("test.txt").createNewFile();
        //try (
        //    FileInputStream in = new FileInputStream("test.txt");
        //    FileOutputStream out = new FileOutputStream("test.txt");
        //    FileChannel channelIn = in.getChannel();
        //    FileChannel channelOut = out.getChannel();
        //){
        //    ByteBuffer buffer = ByteBuffer.allocate(1024);
        //    buffer.put("hello world".getBytes());
        //    buffer.flip();
        //    channelOut.write(buffer);
        //    buffer.clear();
        //    channelIn.read(buffer);
        //    buffer.flip();
        //    System.out.println(new String(buffer.array(), 0, buffer.remaining()));
        //}



        //// 文件io
        //new File("test.txt").createNewFile();
        //try (
        //        RandomAccessFile raf = new RandomAccessFile("test.txt", "rw");
        //        FileChannel channel = raf.getChannel();
        //){
        //    ByteBuffer buffer = ByteBuffer.allocate(1024);
        //    buffer.put("朱建民帅逼".getBytes());
        //    buffer.flip();
        //    channel.write(buffer);
        //    buffer.clear();
        //    channel.position(0); //Channel也有pos变量，记得重置
        //    channel.read(buffer);
        //    buffer.flip();
        //    System.out.println(new String(buffer.array(), 0, buffer.remaining())); //朱建民帅逼
        //}

        //// 借助FileChannel实现文件内容复制
        //new File("test.txt").createNewFile();
        //new File("testNew.txt").createNewFile();
        //try (
        //        RandomAccessFile raf1 = new RandomAccessFile("test.txt", "rw");
        //        RandomAccessFile raf2 = new RandomAccessFile("testNew.txt", "rw");
        //        FileChannel channelSrc = raf1.getChannel();
        //        FileChannel channelTarget = raf2.getChannel();
        //){
        //    channelSrc.transferTo(0,channelSrc.size(),channelTarget);
        //}

        //// 借助FileChannel实现文件内容编辑
        //new File("test.txt").createNewFile();
        //try (
        //        RandomAccessFile raf = new RandomAccessFile("test.txt", "rw");
        //        FileChannel channel = raf.getChannel();
        //){
        //    byte[] newData = "我花开时百花杀".getBytes();
        //    MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, newData.length);
        //    //mappedByteBuffer.position(3);
        //    mappedByteBuffer.put(newData);
        //    mappedByteBuffer.force();
        //}

        // 文件锁FileLock，Channel支持文件加锁
        //new File("test.txt").createNewFile();
        //try (
        //        RandomAccessFile raf = new RandomAccessFile("test.txt", "rw");
        //        FileChannel channel = raf.getChannel();){
        //    FileLock lock = channel.lock(0, channel.size(), true); //加锁，true表示共享锁
        //    lock.release(); //释放锁
        //}

        // tryLock()避免加锁失败时阻塞进程
        new File("test.txt").createNewFile();
        try (
                RandomAccessFile raf = new RandomAccessFile("test.txt", "rw");
                FileChannel channel = raf.getChannel();){
            FileLock lock = channel.tryLock(0, channel.size(), true); //加锁，true表示共享锁
            lock.release(); //释放锁
        }


    }
}
