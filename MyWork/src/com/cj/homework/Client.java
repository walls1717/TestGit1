package com.cj.homework;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Booking booking = new Booking();
        //用来控制循环终止
        boolean flag = true;
        //接收客户输入的字符串
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (flag) {
            System.out.println("顾客-a，管理员-b，查看剩余票数-c，退出-e");
            key = scanner.nextLine();
            switch (key) {
                case "a":
                    System.out.println("欢迎光临");
                    System.out.println("一等坐-1，二等座-2");
                    int sc = scanner.nextInt();
                    booking.user(sc);
                    break;
                case "b":
                    booking.adm();
                    break;
                case "c":
                    booking.check();
                    break;
                case "e":
                    scanner.close();
                    flag = false;
                    break;
            }
        }
        System.out.println("程序退出");
    }
}
