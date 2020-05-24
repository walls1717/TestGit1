package com.cj.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * 测试原型模式(深复制，使用序列化和反序列化的方式实现)
 *
 * @author CJ
 */

public class Client03 {
    public static void main(String[] args) throws Exception {
        Date date = new Date(234523523452345L);
        Sheep01 s1 = new Sheep01("少利", date);

        System.out.println("原型对象属性值");
        System.out.println(s1);
        System.out.println(s1.getName());
        System.out.println(s1.getBirthday());

//        Sheep01 s2 = (Sheep01) s1.clone();

        //使用序列化和反序列化实现深复制
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(s1);
        byte[] bytes = bos.toByteArray();

        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bis);
        Sheep01 s2 = (Sheep01) ois.readObject(); //克隆好的对象

        System.out.println("修改原型对象属性值");
        date.setTime(234234L);
        System.out.println(s1.getBirthday());

        System.out.println("clone对象属性值");
        s2.setName("多利");
        System.out.println(s2);
        System.out.println(s2.getName());
        System.out.println(s2.getBirthday());


    }
}
