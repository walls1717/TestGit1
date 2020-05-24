package com.cj.prototype;

import java.util.Date;

/**
 * 测试原型模式(浅克隆)
 *
 * @author CJ
 */

public class Client01 {
    public static void main(String[] args) throws Exception {
        Date date = new Date(234523523452345L);
        Sheep01 s1 = new Sheep01("少利", date);
        System.out.println(s1);
        System.out.println(s1.getName());
        System.out.println(s1.getBirthday());
        date.setTime(234234L);
        System.out.println(s1.getBirthday());

        Sheep01 s2 = (Sheep01) s1.clone();
        s2.setName("多利");
        System.out.println(s2);
        System.out.println(s2.getName());
        System.out.println(s2.getBirthday());
    }
}
