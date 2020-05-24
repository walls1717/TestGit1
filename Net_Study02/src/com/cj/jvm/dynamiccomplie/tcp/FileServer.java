package com.cj.jvm.dynamiccomplie.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 存储文件
 * 创建客户端
 * 1.指定端口 使用ServerSocket创建服务器
 * 2.阻塞式等待连接 accept
 * 3.操作：输入输出流操作
 * 4.释放资源
 *
 * @author CJ
 */

public class FileServer {
    public static void main(String[] args) throws IOException {
        System.out.println("------Server------");
        //1.指定端口 使用ServerSocket创建服务器
        ServerSocket server = new ServerSocket(8888);
        //2.阻塞式等待连接 accept
        Socket client = server.accept();
        System.out.println("一个客户端建立了连接");
        //3.操作：文件的拷贝 存储
        InputStream is = new BufferedInputStream(client.getInputStream());
        OutputStream os = new BufferedOutputStream(new FileOutputStream("D:/IntelliJ IDEA/Test/Net_Study02/src/com/cj/tcp/tcp.png"));
        byte[] flush = new byte[1024];
        int len = -1;
        while ((len = is.read(flush)) != -1) {
            os.write(flush, 0, len);
        }
        os.flush();
        //4.释放资源
        os.close();
        is.close();
        client.close();
    }
}
