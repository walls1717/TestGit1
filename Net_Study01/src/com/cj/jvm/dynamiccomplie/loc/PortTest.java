package com.cj.jvm.dynamiccomplie.loc;

import java.net.InetSocketAddress;

/**
 * 端口：
 * 1.区分软件
 * 2.2个字节 0-65535 UDP TCP
 * 3.同一个协议端口不能冲突
 * 4.定义端口越大越好
 * InetSocketAddress
 * 1.new InetSocketAddress("地址\域名", 端口)；
 * 2.方法：
 *   getAddress()：获取地址
 *   getPort()：获取端口
 *   getHostName()：获取名称
 *
 * @author CJ
 */

public class PortTest {
    public static void main(String[] args) {
        //包含端口
        //
        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 8080);
        InetSocketAddress socketAddress2 = new InetSocketAddress("localhost", 9000);
        System.out.println(socketAddress.getHostName()); //获取构造器中地址的主机名
        System.out.println(socketAddress.getAddress()); //获取构造器中的地址
        System.out.println(socketAddress2.getAddress()); //获取地址
        System.out.println(socketAddress2.getPort()); //获取端口
    }
}

/**
 * 默认端口：
 * 80：http协议
 * 8080：tomcat服务器
 * 1521：oracle
 * 3306：mySQl
 *
 * Windows Dos命令查看端口
 * 查看所有端口：netstat -ano
 * 查看指定端口：netstat -ano|findstr "xxx"
 * 查看指定进程：tasklist|findstr "xxx"
 * 查看具体程序：是用任务管理器查看PID
 */
