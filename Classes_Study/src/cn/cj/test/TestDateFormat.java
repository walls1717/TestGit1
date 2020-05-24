package cn.cj.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 测试时间对象和字符串之间的互相转化
 * DateFormat抽象类和SimpleDateFormat实现类的使用
 * @author CJ
 */

public class TestDateFormat {
    public static  void main(String[] args) throws ParseException {

        //把时间对象按照“格式字符串指定格式”转化成相应字符串
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String str = df.format(new Date(400000));
        System.out.println(System.currentTimeMillis());
        System.out.println(str);

        //把字符串按照“格式字符串指定的格式”转化成相应的事件对象
        DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = df2.parse("2020-3-1 10:00:00");
        System.out.println(date);

        //测试其他的格式字符
        DateFormat df3 = new SimpleDateFormat("D");
        String str3 = df3.format(new Date());
        System.out.println(str3);
    }
}
