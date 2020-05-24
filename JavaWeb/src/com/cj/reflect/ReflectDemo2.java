package com.cj.reflect;

import com.cj.domain.Person;

import java.lang.reflect.Constructor;

/**
 * 反射：测试获取构造方法
 *
 * @author CJ
 * @version 2020-5-20
 */
public class ReflectDemo2 {
    public static void main(String[] args) throws Exception {
        Class<Person> personClass = Person.class;

        Constructor[] constructors = personClass.getConstructors();

        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        System.out.println("=========================");
        Constructor<Person> constructor = personClass.getConstructor(String.class, String.class, int.class);
        System.out.println(constructor);

        //创建对象
        Person person = constructor.newInstance("张三", "nan", 19);
        System.out.println(person);

        System.out.println("===========");
        Person person1 = personClass.newInstance();
        System.out.println(person1);
    }
}
