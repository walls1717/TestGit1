package cn.cj.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * 可视化日历程序
 * @author CJ
 */

public class TestCalendar {
    public static void main(String[] args) throws ParseException {
        //从键盘获取日期，以字符串的形式储存
        System.out.println("请输入日期（格式为：2010-3-3）：");
        Scanner scanner = new Scanner(System.in);
        String dateString = scanner.nextLine();
        //将刚刚从键盘获取的字符串转化为日期类
        System.out.println("你刚刚输入的日期是："+dateString);
        String[] str = dateString.split("-");//分割
        int year = Integer.parseInt(str[0]);//将字符串参数作为有符号的十进制数进行解析
        int month = new Integer(str[1]);
        int day = new Integer(str[2]);
        Calendar c = new GregorianCalendar(year, month - 1, day);//month减1是因为0-11表示月份
        c.set(Calendar.DATE, 1);//将DATE置为1
        int dow = c.get(Calendar.DAY_OF_WEEK);//设置dow用来储存一周内的第几天，周几
        System.out.println("日\t一\t二\t三\t四\t五\t六");
        for(int i = 0; i < dow - 1; i++){
            System.out.print("\t");
        }
        int maxDate = c.getActualMaximum(Calendar.DATE);//用maxDate来存储一个月内拥有天数的最大值
        for(int i = 1; i <= maxDate; i++){
            StringBuilder sBuilder = new StringBuilder();
            if (c.get(Calendar.DATE) == day) {//如果获得的日期与输入的日期相等就在日期前面加上*
                sBuilder.append(c.get(Calendar.DATE) + "*\t");
            }else{//否则就继续打印
                sBuilder.append(c.get(Calendar.DATE) + "\t");
            }
            System.out.print(sBuilder);
            if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {//如果等于周六就换行
                System.out.print("\n");
            }
            c.add(Calendar.DATE, 1);//每打完 一次日期加一天
        }
    }
}

