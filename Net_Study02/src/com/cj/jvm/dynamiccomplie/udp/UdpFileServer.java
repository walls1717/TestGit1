package com.cj.jvm.dynamiccomplie.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 文件存储：
 * 接收端
 * Address already in use: Cannot bind 同一个协议下端口不允许冲突
 * 1.使用DatagramSocket 指定端口 创建接收端
 * 2.准备容器封装成DatagramPacket包裹
 * 3.阻塞式接受包裹 receive(DatagramPacket)
 * 4.分析数据  将字节数组还原为对应的类型即可
 * byte[] getData()
 * 5.释放资源
 *
 * @author CJ
 */

public class UdpFileServer {
    public static void main(String[] args) throws Exception {
        System.out.println("接收方启动中...");
        //1.使用DatagramSocket 指定端口 创建接收端
        DatagramSocket server = new DatagramSocket(9999);
        //2.准备容器封装成DatagramPacket包裹
        byte[] container = new byte[1024 * 60];
        DatagramPacket packet = new DatagramPacket(container, 0, container.length);
        //3. 阻塞式接受包裹 receive (DatagramPacket)
        server.receive(packet); //阻塞式
        //4. 分析数据  将字节数组还原为对应的类型即可
        //byte[] getData ()
        byte[] datas = packet.getData();
        IOUtils.ByteArrayToFile(datas, "D:/IntelliJ IDEA/Test/Net_Study02/src/copy.gif");
        //5. 释放资源
        server.close();
    }
}
