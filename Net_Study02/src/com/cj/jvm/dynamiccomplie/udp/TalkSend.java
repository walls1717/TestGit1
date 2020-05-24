package com.cj.jvm.dynamiccomplie.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 发送端：使用面向对象封装
 *
 * @author CJ
 */

public class TalkSend implements Runnable {
    private DatagramSocket client;
    private BufferedReader reader;
    private String toIP; //接受端 IP
    private int toPort; //接收端 端口

    public TalkSend(int port, String toIP, int toPort) {
        this.toIP = toIP;
        this.toPort = toPort;
        try {
            client = new DatagramSocket(port); //指定端口 创建发送端
            reader = new BufferedReader(new InputStreamReader(System.in)); //从键盘获取内容
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            String data;
            try {
                data = reader.readLine();
                byte[] datas = data.getBytes();
                //3.封装成DatagramPacket包裹，需要制定目的地
                DatagramPacket packet = new DatagramPacket(datas, 0, datas.length,
                        new InetSocketAddress(this.toIP, this.toPort));
                //4.发送包裹send(DatagramPacket p) *
                client.send(packet);
                if (data.equals("bye")) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //5.释放资源
        client.close();
    }
}
