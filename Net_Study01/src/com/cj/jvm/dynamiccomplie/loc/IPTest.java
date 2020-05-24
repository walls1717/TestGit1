package com.cj.jvm.dynamiccomplie.loc;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * IP；定位一个节点：计算机、路由、通信设备
 * InetAddress：多个静态方法
 * 1.getLocalHost()：本机
 * 2.getByName()：根据域名DNS | IP地址 --> IP
 *
 * 两个成员方法
 * 1.getHostAddress()：返回地址
 * 2.getHostName()：返回计算机名
 *
 * @author CJ
 */

public class IPTest {
    public static void main(String[] args) throws UnknownHostException {
        //使用getLocalHost方法创建InetAddress对象 本机
        InetAddress addr = InetAddress.getLocalHost();
        System.out.println(addr.getHostAddress()); //返回Ip地址
        System.out.println(addr.getHostName()); //输出计算机名

        //根据域名得到InetAddress对象
        addr = InetAddress.getByName("www.163.com");
        System.out.println(addr.getHostAddress());//返回163服务器的ip
        System.out.println(addr.getHostName()); //输出www.163.com

        //根据IP得到InetAddress对象
        addr = InetAddress.getByName("123.149.174.21");
        System.out.println(addr.getHostAddress()); //返回指定IP
        //输出的是IP而不是域名。
        //如果这个IP地址不存在或DNS服务器不允许进行IP地址喝域名的映射
        //getHostName()就直接返回这个IP地址
        System.out.println(addr.getHostName());
    }
}
