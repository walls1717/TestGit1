package com.cj.testwork;

import java.util.Scanner;

/**
 * 从键盘获取一个数并计算阶乘
 * @author CJ
 */

public class TestWork07 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.print("请输入一个正整数：");
        int num = s.nextInt();
        TestWork07 u1 = new TestWork07();//创建一个新的对象
        System.out.println(num+"的阶乘是："+u1.factorial(num));//调用factorial并输出
    }
    //求阶乘的方法
    int factorial(int a){
        if (a == 1){
            return 1;
        }else{
            return a * factorial(a-1);
        }
    }
}
