package demo.zjm._07IO与网络编程._17TCP编程;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {

    }

    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        try {
            socket = new Socket(InetAddress.getLocalHost(), 2451);
            os = socket.getOutputStream();
            os.write(("I'm " + InetAddress.getLocalHost()).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void server() {
        ServerSocket serverSocket = null;
        Socket accept = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            serverSocket = new ServerSocket(2451);
            accept = serverSocket.accept();
            is = accept.getInputStream();
            byte[] buf = new byte[1024];
            int len = 0;
            baos = new ByteArrayOutputStream();
            while ((len = is.read(buf)) != -1) {
                baos.write(buf, 0, len);
            }
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (accept != null) {
                try {
                    accept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void clientUpload() {
        Socket socket = null;
        OutputStream os = null;
        InputStream is = null;
        FileInputStream fis = null;
        ByteArrayOutputStream baos = null;
        try {
            socket = new Socket(InetAddress.getLocalHost(), 4044);
            os = socket.getOutputStream();
            is = socket.getInputStream();
            fis = new FileInputStream(new File("src/_07IO与网络编程/_17TCP编程/朱建民的头像.jpg"));
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = fis.read(buf)) != -1) {
                os.write(buf, 0, len);
            }
            //这里要手动终止接口的输出流，因为这个网络通信数据是没有文件结束标记
            socket.shutdownOutput();
            baos = new ByteArrayOutputStream();
            while ((len = is.read(buf)) != -1) {
                baos.write(buf, 0, len);
            }
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void serverGet() {
        ServerSocket serverSocket = null;
        Socket accept = null;
        InputStream is = null;
        OutputStream os = null;
        FileOutputStream fos = null;
        try {
            serverSocket = new ServerSocket(4044);
            accept = serverSocket.accept();
            fos = new FileOutputStream(new File("src/_07IO与网络编程/_17TCP编程/朱建民的头像0.jpg"));
            os = accept.getOutputStream();
            is = accept.getInputStream();
            byte[] buf = new byte[1034 * 8];
            int len = 0;
            while ((len = is.read(buf)) != -1) {
                fos.write(buf, 0, len);
            }
            os.write("已收到文件!".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (accept != null) {
                try {
                    accept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
