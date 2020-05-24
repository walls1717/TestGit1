package com.cj.jvm.dynamiccomplie.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 接收端：
 *
 * @author CJ
 */

public class TalkReceive implements Runnable {
    private DatagramSocket server;
    private String from; //用来存储是谁发过来的数据

    public TalkReceive(int port, String from) {
        this.from = from;
        try {
            server = new DatagramSocket(port); //指定端口 创建接收端
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            //2.准备容器封装成DatagramPacket包裹
            byte[] container = new byte[1024 * 60];
            DatagramPacket packet = new DatagramPacket(container, 0, container.length);
            //3. 阻塞式接受包裹 receive (DatagramPacket)
            try {
                server.receive(packet); //阻塞式
                //4. 分析数据
                byte[] datas = packet.getData();
                int len = packet.getLength();
                String data = new String(datas, 0, len);
                System.out.println(from + "：" + data);
                if (data.equals("bye")) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //5. 释放资源
        server.close();
    }
}
