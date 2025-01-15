package demo.zjm.阻塞到非阻塞.传统IO;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @program: demo_techIntegrate
 * @ClassName: Client
 * @description:
 * @author: AlanMa
 * @create: 2024-12-06 22:23
 */
public class Client {
    public static void main(String[] args) {
        try (
                Socket socket = new Socket("localhost", 8080);
                Scanner scanner = new Scanner(System.in);
        ) {
            //连接到服务端
            System.out.println("已连接到服务端！");

            // 发送数据到服务端
            System.out.println("请输入要发送给服务端的内容：");
            String text = scanner.nextLine();
            OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());
            writer.write(text + '\n');
            writer.flush();
            System.out.println("数据已发送！");

            // 接收服务端返回的数据
            System.out.println("收到服务器的响应"+text);
            System.out.println(new BufferedReader(new InputStreamReader(socket.getInputStream())).readLine());

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
