package com.cj.testwork;

import java.util.Scanner;

public class TestWork04 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.print("请输入一个十位数整数：");
        int a = s.nextInt();
        System.out.println("二进制数为："+binaryNum(a));//调用求二进制方法，并打印结果
        add();//调用求和方法
        int b = sequence(40);//调用求斐波那契数列第四十位方法并放入b中
        System.out.println("第四十个数是："+b);//输出斐波那契数列第四十位
    }

    //十进制转化为二进制方法
    static String binaryNum(int a){
        String s = Integer.toBinaryString(a);
        return s;
    }
    //求和方法
    static void add(){
        int sum = 0;
        for (int i = 1; i <= 100; i++){
            for (int j = 1; j <= i; j++){
                sum += j;
            }
        }
        System.out.println("一到一百每个数求和并相加为："+sum);
    }
    //求斐波那契数列随意一个一位数字方法
    static int sequence(int a){
        if (a == 1 || a == 2) {
            return 1;
        }else{
            return (sequence(a-1)+(sequence(a-2)));
        }
    }
}
