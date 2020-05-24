package com.cj.homework;

import java.util.Scanner;

public class Booking {
    //一等座
    public int[] oneSite = new int[5];
    //二等座
    public int[] twoSite = new int[5];

    //用来表示用户
    public void user(int num) {
        if (num == 1) {
            System.out.println("一等座");
            System.out.println("你想购买几张票？");
            Scanner scanner = new Scanner(System.in);
            int sc = scanner.nextInt();
            //通过用户输入想购买几个车票，并将它们在数组中的值变为1，表示该票已售出
            for(int i = 0; i < sc; i++) {
                System.out.printf("你的座位号是%d\n", i+1);
                oneSite[i] = 1;
            }
        } else if (num == 2) {
            System.out.println("二等座");
            System.out.println("你想购买几张票？");
            Scanner scanner = new Scanner(System.in);
            int sc = scanner.nextInt();
            //通过用户输入想购买几个车票，并将它们在数组中的值变为1，表示该票已售出
            for(int i = 0; i < sc; i++) {
                System.out.printf("你的座位号是%d\n", i+1);
                twoSite[i] = 1;
            }
        } else {
            System.out.println("输入有误，请重新输入");
        }

    }

    public void update(int[] oneSite, int[] twoSite) {
        //管理员可以将所有票数全置为满票
        for(int i = 0; i < oneSite.length; i++){
            oneSite[i] = 0;
        }
        for(int i = 0; i < twoSite.length; i++){
            twoSite[i] = 0;
        }
    }

    public void adm() {
        System.out.println("请输入你的工号和密码");
        Scanner scanner = new Scanner(System.in);
        //接收id
        String id = scanner.nextLine();
        //接收密码
        String pwd = scanner.nextLine();
        if (id.equals("123") && pwd.equals("chengjie")) {
            System.out.println("输入正确，欢迎");
            System.out.println("是否将所有票恢复? yes or no");
            String sc = scanner.nextLine();
            //如果输入yes就将所有票恢复，输入no就退出
            if (sc.equals("yes")) {
                update(oneSite, twoSite);
            } else if (sc.equals("no")) {
                System.out.println("谢谢");
            }
        }
    }

    //检查剩余的票数
    public void check() {
        System.out.println("剩余的票数");
        int count = 0;
        int count2 = 0;
        for(int i = 0; i < oneSite.length; i++) {
            if (oneSite[i] == 0) {
                count++;
            }
        }
        for(int i = 0; i < twoSite.length; i++) {
            if (twoSite[i] == 0) {
                count2++;
            }
        }
        System.out.printf("一等座剩余%d张\n", count);
        System.out.printf("二等座剩余%d张\n", count2);
    }
}