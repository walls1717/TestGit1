package com.cj.testwork;

import java.util.Scanner;

/**
 * 计算圆的周长和面积
 * @author CJ
 */

public class TestWork01 {
    public static void main(String[] args){
        //定义常量PI
        final float PI = 3.14F;
        //从键盘获取圆的半径
        Scanner s = new Scanner(System.in);
        System.out.println("请输入圆的半径：");
        double r = s.nextDouble();
        //计算圆的周长和面积
        double perimeter = PI*(r*2);
        double area = PI*r*r;
        //打印结果
        System.out.println("圆的半径是："+r);
        System.out.println("圆的周长是："+perimeter);
        System.out.println("圆的面积是："+area);
    }
}
