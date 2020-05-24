package com.cj.testwork;

import java.util.Scanner;

/**
 * 判断一年是否为闰年
 * @author CJ
 */

public class TestWork05 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        //从键盘获取年份
        System.out.print("请输入一个年份：");
        int year = s.nextInt();
        leapYear(year);//调用计算是否为闰年的方法leapYear
    }

    //计算是否为闰年
    static void leapYear(int year){
        if (year%4==0 && year%100!=0){
            System.out.println(year+"是闰年");
        }else if (year%400==0){
            System.out.println(year+"是闰年");
        }else{
            System.out.println(year+"不是闰年");
        }
    }
}
