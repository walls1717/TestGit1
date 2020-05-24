package cn.operator;

import java.util.Scanner;

/**
 * 判断是否为工作日
 * @author CJ
 */

public class TestOperator14 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        //从键盘获取数字
        System.out.println("今天周几？");
        int days = s.nextInt();
        //判断是否为工作日
        String weekend = days>5?"今天是休息日":"今天是工作日";
        System.out.println(weekend);
    }
}
