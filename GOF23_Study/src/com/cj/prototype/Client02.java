package com.cj.prototype;

import java.util.Date;

/**
 * 测试原型模式(深赋值)
 *
 * @author CJ
 */

public class Client02 {
    public static void main(String[] args) throws Exception {
        Date date = new Date(234523523452345L);
        Sheep02 s1 = new Sheep02("少利", date);
        Sheep02 s2 = (Sheep02) s1.clone(); //实现深复制。s2的birthday是一个新对象。

        System.out.println(s1);
        System.out.println(s1.getName());
        System.out.println(s1.getBirthday());
        date.setTime(234234L);
        System.out.println(s1.getBirthday());

        s2.setName("多利");
        System.out.println(s2);
        System.out.println(s2.getName());
        System.out.println(s2.getBirthday());


    }
}
