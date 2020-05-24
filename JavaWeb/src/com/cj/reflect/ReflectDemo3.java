package com.cj.reflect;

import com.cj.domain.Person;

import java.lang.reflect.Method;

/**
 * 反射：获取方法
 * @version 2020-5-20
 * @author CJ
 */
public class ReflectDemo3 {
    public static void main(String[] args) throws Exception {
        var personClass = Person.class;

        //获取所有方法
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
            String name = method.getName();
            System.out.println(name);
        }

        System.out.println("==================");

        //获取方法
        Method eat = personClass.getMethod("eat", String.class);
        var p = new Person();
        eat.invoke(p, "Food");

        System.out.println("=========");
        String name = personClass.getName();
        System.out.println(name);
    }
}
