package demo.zjm.Buffer;



import com.alibaba.druid.sql.visitor.functions.Char;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;

/**
 * @program: demo_techIntegrate
 * @ClassName: Main
 * @description: Buffer的基本操作
 * @author: AlanMa
 * @create: 2024-11-08 09:37
 */
public class Main {
    public static void main(String[] args) {

        // 创建缓冲区的两种方式
        IntBuffer intBuffer0 = IntBuffer.allocate(1024);
        int[] ints = new int[1024];
        IntBuffer intBuffer1 = IntBuffer.wrap(ints);

        // Buffer的读写
        intBuffer0.put(0, 1);
        System.out.println(intBuffer0.get(0)); // 1

        // 使用position()方法获取当前指针位置，并使用limit()方法获取缓冲区的限制位置
        // 使用array()方法获取缓冲区中的数据
        // get()方法读取缓冲区中的数据，并将指针移动到下一个位置
        IntBuffer intBuffer2 = IntBuffer.allocate(2);
        System.out.println(intBuffer2.get()); // 0
        System.out.println(intBuffer2.get()); // 0
        System.out.println(intBuffer2.position()); // 2
        // System.out.println(intBuffer2.get()); // java.nio.BufferUnderflowException
        // put()方法向缓冲区中写入数据，并将指针移动到下一个位置
        intBuffer2 = IntBuffer.allocate(3); // 重新分配缓冲区
        System.out.println(intBuffer2.position()); // 0
        intBuffer2.put(1);
        System.out.println(intBuffer2.position()); // 1
        System.out.println((Arrays.toString(intBuffer2.array()))); //[1, 0, 0]
        // 带下标的put()、get()方法，不会移动position
        intBuffer2.put(0, 2);
        System.out.println(Arrays.toString(intBuffer2.array())); // [2, 0,0]
        System.out.println(intBuffer2.position()); // 1
        intBuffer2.put(2, 3);
        System.out.println(intBuffer2.position()); // 1
        System.out.println(intBuffer2.get(1)); // 0
        System.out.println(intBuffer2.position()); // 1
        // put也可以按数组写入，position不会移动
        int[] arr = {4, 5, 6};
        intBuffer2.put(0,arr,2,1); // 从数组arr的下标2开始写入1个元素到缓冲区的下标0
        System.out.println(Arrays.toString(intBuffer2.array())); // [6, 0, 3]
        System.out.println(intBuffer2.position()); // 1
        // buffer支持builder模式
        IntBuffer intBuffer3 = IntBuffer.allocate(3);    // 重新分配缓冲区
        intBuffer3.put(1).put(2).put(3);
        System.out.println(Arrays.toString(intBuffer3.array())); // [1, 2, 3] return fromIndex;

        // 注意put参数为Buffer时，写入的下标范围是pos到lim，position会向后移动的
        IntBuffer src = IntBuffer.allocate(5);
        for (int i = 0; i < 5; i++) src.put(i);   //手动插入数据
        IntBuffer buffer = IntBuffer.allocate(10);
        buffer.put(src);
        System.out.println(Arrays.toString(buffer.array()));    // [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        // 要避免这种情况只能先用flip()方法翻转缓冲区，再用put()方法写入
        src.flip(); // limit = position; position = 0;mark = -1;
        buffer.put(src);
        System.out.println(Arrays.toString(buffer.array())); //[0, 1, 2, 3, 4, 0, 0, 0, 0, 0]
        System.out.println(buffer.position()); // 5

        //读操作，获取当前pos的元素，并移动pos到下一个位置
        buffer.flip();
        System.out.println(buffer.get()); // 0
        System.out.println(buffer.get()); // 1
        System.out.println(buffer.get()); // 2

        // 带下标的get()方法，不会移动position
        buffer.flip();
        System.out.println(buffer.get(1)); // 1
        System.out.println(buffer.position()); // 0

        // get读取到数组中，position向后移动
        int[] intss = new int[3];
        int[] intsss = new int[4];
        buffer.get(intss);
        System.out.println(Arrays.toString(intss)); //[0, 1, 2]
        System.out.println(buffer.position()); // 3
        //buffer.flip();
        //buffer.get(intsss); //接收数组不够长，会抛出java.nio.BufferUnderflowException

        // 带下标的读取到数组中，数组长度可以定义更加灵活，position向后移动
        buffer.flip();
        buffer.get(intsss, 1, 2);
        buffer.put(1, 10);
        System.out.println(Arrays.toString(intsss)); //[0, 0, 1, 0]
        System.out.println(buffer.position()); //2

        // 直接用array()方法获取缓冲区中的数据，position不会移动
        buffer.position(0);
        System.out.println(Arrays.toString(buffer.array())); // [0, 10, 2, 3, 4, 0, 0, 0, 0, 0]
        System.out.println(buffer.position()); // 0
        // 遍历所有元素
        buffer.position(0);
        while (buffer.hasRemaining()) {
            System.out.print(buffer.get() +" "); //0 10 2
        }
        System.out.println();
        buffer.position(0);

        // 获取底层hb数组
        int[] hb = buffer.array();
        hb[0] = 10;
        System.out.println(Arrays.toString(buffer.array())); //[10, 10, 2, 3, 4, 0, 0, 0, 0, 0]

        // mark()方法标记当前位置，reset()方法回到标记的位置
        buffer.position(1);
        buffer.mark();
        buffer.position(3);
        buffer.reset();
        System.out.println(buffer.position()); // 1

        buffer = IntBuffer.wrap(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        buffer.position(2);
        buffer.compact();
        System.out.println(Arrays.toString(buffer.array())); // [3, 4, 5, 6, 7, 8, 9, 10, 9, 10]
        System.out.println(buffer.position()); // 8

        // 其他Buffer操作，如slice()、asReadOnlyBuffer()、order()
        // duplicate()方法复制缓冲区，position不会移动
        buffer = IntBuffer.wrap(new int[]{1, 2, 3, 4, 5});
        System.out.println(Arrays.toString(buffer.duplicate().array())); //[1, 2, 3, 4, 5]

        // slice()方法复制缓冲区，position不会移动
        buffer = IntBuffer.wrap(new int[]{1, 2, 3, 4, 5});
        buffer.position(2);
        buffer = buffer.slice(); //return new HeapIntBuffer(hb,-1,0,rem,rem,pos + offset, segment);
        System.out.println(Arrays.toString(buffer.array())); // [1, 2, 3, 4, 5]
        System.out.println(buffer.arrayOffset()); //2
        System.out.println(buffer.position()); // 0

        // rewind()对pos、mark重置
        buffer.position(2);
        buffer.rewind();
        System.out.println(buffer.position()); // 0

        // clear()方法将所有变量重置
        buffer.clear(); // position = 0; limit = capacity; mark = -1;
        System.out.println(Arrays.toString(buffer.array())); //[1, 2, 3, 4, 5]
        System.out.println(buffer.arrayOffset()); //offset就是初始的位置没有变化

        // 缓冲区比较equals()方法
        IntBuffer buffer1 = IntBuffer.wrap(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0});
        IntBuffer buffer2 = IntBuffer.wrap(new int[]{6, 5, 4, 3, 2, 1, 7, 8, 9, 0});
        System.out.println(buffer1.equals(buffer2));   //直接比较false
        buffer1.position(6);
        buffer2.position(6);
        System.out.println(buffer1.equals(buffer2));   //比较从下标6开始的剩余内容，true
        // IntBuffer实现了Comparable接口，compareTo()方法比较两个缓冲区的元素
        System.out.println(buffer1.compareTo(buffer2)); // 比较pos以后的全部元素，返回第一个不相同的元素的比较结果，0


        // asReadOnlyBuffer()方法创建只读缓冲区
        buffer = IntBuffer.wrap(new int[]{1, 2, 3, 4, 5});
        IntBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();
        //readOnlyBuffer.put(0, 10); // java.nio.ReadOnlyBufferException

        // ByteBUffer底层是byte数组
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        byteBuffer.putInt(Integer.MAX_VALUE); //允许添加int类型数据
        byteBuffer.flip();
        while (byteBuffer.hasRemaining()){
            System.out.print(byteBuffer.get() + " "); //127 -1 -1 -1
        }
        System.out.println();

        //字符缓冲流
        CharBuffer charBuffer = CharBuffer.allocate(10);
        charBuffer.put("helloworld"); //可以直接放入整个字符串
        charBuffer.flip();
        System.out.println(charBuffer);// hello world 可以看出toString()方法可以将缓冲区中的数据转换为字符串
        System.out.println(charBuffer.charAt(2));// l，支持类似StringBuffer的操作
        // 用chars()方法获取缓冲区中的字符，返回IntStream
        System.out.println(charBuffer.chars()); // StreamSupport.intStream(...)
        charBuffer.chars().map((c) -> (char) (c + 1)).forEach((c)-> System.out.print((char) c + " "));
        System.out.println();
        // 也可以直接wrap()创建
        charBuffer  = CharBuffer.wrap("helloworld"); // 底层是创建一个StringCharBuffer，并设置isReadOnly为true
        charBuffer.put("java"); // ReadOnlyBufferException


        // 直接缓冲区，底层数组存放在非堆内存中，可以直接进行操作系统IO操作，适合于大数据量的读写
        byteBuffer = ByteBuffer.allocateDirect(10);
        // 使用方式基本和之前是一样的
        byteBuffer.put((byte) 66);
        byteBuffer.flip();
        System.out.println(byteBuffer.get());

    }
}
