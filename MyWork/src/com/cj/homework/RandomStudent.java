package com.cj.homework;

import java.util.Random;
import java.util.Scanner;

public class RandomStudent {
    public static void student(String[] strings) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < strings.length; i++) {
            System.out.printf("请输入第%d个同学的名字", i);
            String name = sc.nextLine();
            strings[i] = name;
        }
    }

    public static void show(String[] strings){
        System.out.println();
        System.out.println("所有同学");
        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static void random(String[] strings){
        System.out.println();
        System.out.println("随机抽取到的同学名字为");
        int index = new Random().nextInt(strings.length);
        String name = strings[index];
        System.out.println(name);
    }

    public static void main(String[] args) {
        String[] strings = new String[3];
        student(strings);
        show(strings);
        random(strings);
    }
}
