package demo.zjm.oj;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @program: demo_techIntegrate
 * @ClassName: OjIO
 * @description:
 * @author: AlanMa
 * @create: 2025-01-03 09:25
 */
public class OjIO {
    // ojio最好使用缓冲字符输入流
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    // StreamTokenizer可以极大地提高输入效率，缺点是无法识别控制字符，也不能自定义分割符号
    // 另外要注意，streamTokenizer识别字符串很呆，数字没法自动转为String用sval获取
    // 注意/开头的每个token都会被忽略
    StreamTokenizer streamTokenizer = new StreamTokenizer(in);
    // StringTokenizer可以自定义分割符号，但是效率不如StreamTokenizer，妈的说好了封装好了还在这无法识别数字为字符串，妈妈的最后还是要自己写个方法转一下。垃圾！
    StringTokenizer stringTokenizer = new StringTokenizer("");

    // 基于StreamTokenizer的readInt()方法
    public int readInt() throws IOException {
        streamTokenizer.nextToken();
        return (int) streamTokenizer.nval;
    }

    public double readDouble() throws IOException {
        streamTokenizer.nextToken();
        return streamTokenizer.nval;
    }

    public String readString() throws IOException {
        streamTokenizer.nextToken();
        return streamTokenizer.sval;
    }

    // StringTokenizer的next()方法，本质上仍然是基于StreamTokenizer的，只是封装了一下而已
    String next() throws IOException {
        while ( ! stringTokenizer.hasMoreTokens() ) {
            stringTokenizer = new StringTokenizer(
                    in.readLine() );
        }
        return stringTokenizer.nextToken();
    }

    // ojio最好使用非缓冲字符输出流，先转Writer再转
    PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        OjIO io = new OjIO();
        StreamTokenizer tokenizer = io.streamTokenizer;
        String line = null;

        //while (!"quit".equals(line)) {
        //    tokenizer.nextToken();
        //    double num = tokenizer.nval;
        //    line = tokenizer.sval;
        //    io.out.println("num = " + num);
        //    io.out.println("line = " + line);
        //}

        //while(!(line = io.readString()).equals("quit")){
        //    io.out.println(line);
        //}

        while(!(line = io.readString()).equals("quit")){
            io.stringTokenizer = new StringTokenizer(line);
            while (io.stringTokenizer.hasMoreTokens()) {
                io.out.println(io.stringTokenizer.nextToken());
                io.out.flush(); // 不要忘记了flush，System.out.println()会自动flush
            }
        }
        System.out.println("quit");
    }

}
