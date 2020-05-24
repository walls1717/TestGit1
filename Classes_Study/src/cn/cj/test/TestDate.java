package cn.cj.test;

import java.util.Date;

/**
 * 测试Date类和常见用法
 *
 * 以后遇到日期处理：使用Calendar
 * @author CJ
 */

public class TestDate {
    public static void main(String[] args){
        Date d = new Date();
        System.out.println(d);
        System.out.println(System.currentTimeMillis());
    }
}
