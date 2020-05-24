package com.cj.reflect;

import com.cj.domain.Person;

import java.lang.reflect.Field;

/**
 * 测试反射获取成员变量方法
 * @version 2020-5-19
 * @author CJ
 */
public class ReflectDemo {
    public static void main(String[] args) throws Exception {
        // 创建反射
        Class<Person> personClass = Person.class;
        // 获取所有 public 成员变量
        Field[] result = personClass.getFields();
        for (Field field : result) {
            System.out.println(field);
        }

        // 获取指定 public 成员变量
        Field a = personClass.getField("a");
        System.out.println(a);

        System.out.println("=====================");
        // 获取所有成员变量
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }

        System.out.println("======================");
        var p = new Person();
        // 给成员变量设置值
        a.set(p, "CJ");
        // 获取成员变量的值
        Object o = a.get(p);
        System.out.println(o);
    }
}