package com.cj.homework;

import java.util.Scanner;

public class Booking2 {
    public static int[] oneSite = new int[5];
    public static int[] twoSite = new int[5];

    public static void user() {
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        while (flag) {
            System.out.println("一等座请按1");
            System.out.println("二等座请按2");
            int num = sc.nextInt();
            if (num == 1) {
                check(1);
            } else if (num == 2){
                check(2);
            } else {
                System.out.println("输入错误");
            }
        }
    }

    public static void adm() {

    }

    public static void check(int num) {
        if (num == 1) {
            for (int i = 0; i < oneSite.length; i++) {
                if (oneSite[i] == 0) {
                    System.out.println("你购买的是第" + i + "张票");
                    oneSite[i] = 1;
                    return;
                }
            }
            for (int i = 0; i < oneSite.length; i++) {
                if (oneSite[i] == 1) {
                    System.out.println("一等座的票已经卖完了");
                    return;
                }
            }
        } else if (num == 2) {
            for (int i = 0; i < twoSite.length; i++) {
                if (twoSite[i] == 0) {
                    System.out.println("你购买的是第" + i + "张票");
                    twoSite[i] = 1;
                    return;
                }
            }
            for (int i = 0; i < twoSite.length; i++) {
                if (twoSite[i] == 1) {
                    System.out.println("二等座的票已经卖完了");
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        user();
    }
}
