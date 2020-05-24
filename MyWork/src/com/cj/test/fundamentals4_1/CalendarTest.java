package com.cj.test.fundamentals4_1;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * 获取本月日历
 * @version 13.0.1 2020-04-25
 * @author CJ
 */
public class CalendarTest {
    public static void main(String[] args) {
        //获取当前的时间
        LocalDate date = LocalDate.now();
        //获取当前月份
        int month = date.getMonthValue();
        //获取当前是几号
        int today = date.getDayOfMonth();

        //将date置为本月第一天，当前日期 - 当前日期-1，结果也就是本月1号
        date = date.minusDays(today - 1);
        //获取当前是星期几，并以整形形式存储
        DayOfWeek weekday = date.getDayOfWeek();
        int value = weekday.getValue();

        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        //确定本月的第一天是星期几
        for(int i = 1; i < value; i++) {
            System.out.print("    ");
        }
        //如果获取的月份是当前月份，循环操作
        while(date.getMonthValue() == month) {
            //每个日期以3个占位符的形式输出
            System.out.printf("%3d", date.getDayOfMonth());
            //如果月份中的一天，等于现在的日期，就将该日期后面加上*
            if (date.getDayOfMonth() == today) {
                System.out.print("*");
            } else { //否则，打印空格
                System.out.print(" ");
            }
            //日期向后递增
            date = date.plusDays(1);
            //如果是星期一，就换行
            if(date.getDayOfWeek().getValue() == 1) {
                System.out.println();
            }
        }
        //循环结束后，如果日期没有到星期一，仍然换行
        if(date.getDayOfWeek().getValue() != 1) {
            System.out.println();
        }
    }
}
