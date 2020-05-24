package com.cj.testwork;

/**
 * 找出所有的水仙花数
 * @author CJ
 */

public class TestWork14 {
    public static void main(String[] args){
        //定义三个变量，用来存数个位，十位，百位
        int j, k, m;
        //循环所有的三位数，并且分解，找出水仙花数
        for(int i = 100; i < 999; i++){
            j = i%10;//个位
            k = (i/10)%10;//十位
            m = (i/100)%10;//百位

            //找出水仙花数，并打印
            if (i == j * j * j + k * k * k + m * m * m) {
                System.out.print(i+"\t");
            }
        }
    }
}
