package com.cj.test;

import java.time.LocalDate;

/**
 * 测试Date类
 * @version 13.0.1 2020-04-25
 * @author CJ
 */
public class DateTest {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        LocalDate newDate = localDate.plusDays(1000);
        System.out.println(newDate);
    }
}
