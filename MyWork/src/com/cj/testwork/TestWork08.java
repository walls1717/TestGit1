package com.cj.testwork;

/**
 * 天朝有一个乞丐姓洪，去天桥要钱
 * 第一天要了1块钱
 * 第二天要了2块钱
 * 第三天要了4块钱
 * 第四天要了8块钱
 * 以此类推
 *
 * 问题： 洪乞丐干10天，收入是多少？
 *
 * @author CJ
 */

public class TestWork08 {
    public static void main(String[] args){
        int moneyEachDay = 0;//每天乞讨多少前
        int sum = 0;//总共乞讨了多少钱
        for (int i = 1; i <= 10; i++){
            //当moneyEachDay为零的时候 令其等于1，此时第一遍循环，i为1，moenyEachDay为1
            if(moneyEachDay==0){
                moneyEachDay = 1;
                //到此处，第二遍循环i为2，moneyEachDay也为2，程序正确运行
            }else{
                moneyEachDay *= 2;
            }
            sum += moneyEachDay;//将乞丐乞讨的钱一天一天的累加
        }
        System.out.println(sum);
    }
}
