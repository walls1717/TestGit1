package com.cj.testwork;

/**
 * 寻找两个数相除，其结果距离黄金分割点0.618最近
 * @author CJ
 */

public class TestWork11 {
    public static void main(String[] args){
        double a = 0;
        double b = 0;
        double sum = 0;
        for( ; ; ){
            a = (int) (20 * Math.random());
            b = (int) (20 * Math.random());
            sum = a/b;
            if (sum >= 0.610 && sum <= 0.620) {
                break;
            }
        }
        System.out.println("距离黄金分割点(0.618)最近的两个数想除是："+a+"/"+b+"="+sum);
    }
}
