package demo.zjm.阻塞到非阻塞.传统IO;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: demo_techIntegrate
 * @ClassName: Server
 * @description: 传统IO模型的服务端
 * @author: AlanMa
 * @create: 2024-12-06 21:59
 */
public class Server {

    public static void main(String[] args) {
        try(ServerSocket server = new ServerSocket(8080);
            // 等待连接
            Socket socket = server.accept()){

            System.out.println("客户端已连接，IP地址为：" + socket.getInetAddress().getHostAddress());

            // 读取客户端数据
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("接收到客户端数据: " + reader.readLine());

            // 向客户端发送数据
            OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());
            writer.write("已收到！\n"); //接收方通过readLine()方法读取数据
            writer.flush();
            //OutputStreamWriter writer = new OutputStreamWriter(client.getOutputStream()); // 这个socker表示的是当前服务器与客户端的连接，所以这里的输出流是客户端的输入流
            //writer.write("已收到！\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

