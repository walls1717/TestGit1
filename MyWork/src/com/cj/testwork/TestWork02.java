package com.cj.testwork;

/**
 * 计算银行存款本息合计
 * @author CJ
 */

public class TestWork02 {
    public static void main(String[] args){
        //定义本金与利率
        int MONEY = 10000;
        double L1 = 0.0035;
        double L2 = 0.0150;
        double L3 = 0.0210;
        //计算本息总计
        int total1 = (int)Math.round(MONEY*(1+L1));//不保留小数，四舍五入
        int total2 = (int)Math.round(MONEY*(1+L2));
        int total3 = (int)Math.round((MONEY*L1)*2+MONEY);
        int total4 = (int)Math.round((MONEY*L3)*2+MONEY);
        //打印结果
        System.out.println("活期一年本金总计："+total1);
        System.out.println("定期一年本金总计："+total2);
        System.out.println("活期两年本金总计："+total3);
        System.out.println("定期两年本金总计："+total4);
    }
}
