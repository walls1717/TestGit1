package com.cj.testwork;

import java.util.Scanner;

/**
 * 通过输入月份来判断季节
 * @author CJ
 */

public class TestWork06 {
    public static void main(String[] args){
        Scanner s =  new Scanner(System.in);
        //从键盘获取月份
        System.out.print("请输入一个月份：");
        int month = s.nextInt();

        //根据月份来不同的输出一年四季
        switch(month){
            case 1:
            case 2:
            case 3:
                System.out.println(month+"月是冬天");
                break;
            case 4:
            case 5:
            case 6:
                System.out.println(month+"月是春天");
                break;
            case 7:
            case 8:
            case 9:
                System.out.println(month+"月是夏天");
                break;
            case 10:
            case 11:
            case 12:
                System.out.println(month+"月是秋天");
                break;
        }
    }
}
