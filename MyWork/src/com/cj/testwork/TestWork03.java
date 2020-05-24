package com.cj.testwork;

import java.util.Scanner;

/**
 * 加密
 * @author CJ
 */

public class TestWork03 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.print("请输入一个4位正整数：");
        int a = s.nextInt();
        //提取个位十位百位千位。经过修改之后，将提取与加密放在了一起，代码更精炼
        int i = ((a%10)+5)%10;
        int j = (((a/10)%10)+5)%10;
        int k = (((a/100)%10)+5)%10;
        int m = (((a/1000)%10)+5)%10;
        /*System.out.println(i);
        System.out.println(j);//此处是在测试个位十位百位千位是否提取正常
        System.out.println(k);
        System.out.println(m);*/
        //加密
        /*int i2 = (i+5)%10;
        System.out.println(i2);
        int j2 = (j+5)%10;//此处是修改之前的加密过程
        int k2 = (k+5)%10;
        int m2 = (m+5)%10;*/
        //打印结果
        System.out.println("加密后的数字为："+(1000*i+100*j+10*k+m));
    }
}
