package com.cj.testwork;

/**
 * 假设你月收入是3000，除开平时花销，每个月留下1000块钱进行投资。
 *
 * 然后你认真的钻研了 《股票和基金 21天从入门到精通》，达到了每年20%的投资回报率。
 *
 * 那么问题来了，以每个月投资1000块钱的节奏，持续投资多少年，总收入达到100万
 * （复利计算按照每年12000投入计算，不按照每月计息）
 */

public class TestWork10 {
    public static void main(String[] args) {
        double F = 0;//最终收入
        double p = 12000;//本金
        double r = 0.2;//利率
        int n = 1;//年份
        int sum = 0;//总共收入

        for(; ;n++) {//此处不设置判断条件，在循环体内用break来控制结束循环
            F = p * Math.pow((1 + r), n);//这个是计算复利的公式
            sum += F;//将每年的利息相加
            System.out.println("第"+n+"年的总收益是："+sum);
            if (sum >= 1000000) {//当总收入大于等于一百万时，结束循环
                break;
            }
        }
        System.out.println("总共需要："+n+"年");
    }
}
