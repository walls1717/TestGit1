package cn.cj.test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 测试calendar类
 * @auhtor CJ
 */

public class TestCalendarClass {
    public static void main(String[] args){
        //获取日期相关元素
        Calendar calendar = new GregorianCalendar(2020, 2, 20, 21, 33, 50);
        int year = calendar.get(Calendar.YEAR);//获取年
        int month = calendar.get(Calendar.MONTH);//获取月
        int weekday = calendar.get(Calendar.DAY_OF_WEEK);//获取星期几，1-7,1:星期日， 2：星期一
        int day = calendar.get(Calendar.DATE);//获取几号，也可以使用DAY_OF_MONTH
        System.out.println(month);//0-11表示月份，0为一月
        System.out.println(year);
        System.out.println(weekday);
        System.out.println(day);

        //设置日期相关元素
        Calendar c2 = new GregorianCalendar();
        c2.set(Calendar.YEAR, 8012);
        c2.set(Calendar.MONTH, 2);
        System.out.println(c2);

        //日期的计算
        Calendar c3 = new GregorianCalendar();
        c3.add(Calendar.DATE, 100);
        System.out.println(c3);

        //日期对象和时间对象的转化
        Date d4 = c3.getTime();//将日期对象转化为时间对象
        Calendar c4 = new GregorianCalendar();
        c4.setTime(new Date());//将时间对象转化为日期对象

        printCalendar(c4);
    }

    public static void printCalendar(Calendar c){
        //打印1918-10-10 11：23：45
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH)+1;//因为0代表1月，这里加1表示将1变为1月
        int day = c.get(Calendar.DAY_OF_MONTH);
        int hour = c.get(Calendar.HOUR);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);
        int dayweek = c.get(Calendar.DAY_OF_WEEK)-1;//因为1代表星期日，这里减1代表将1变为周一
        String dayweek2 = dayweek == 0?"7":dayweek + "";
        System.out.println(year+"-"+month+"-"+day+""+" "+hour+":"+minute+":"+second+" "+dayweek2);
    }
}
