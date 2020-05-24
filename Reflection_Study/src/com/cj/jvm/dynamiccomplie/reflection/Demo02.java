package com.cj.jvm.dynamiccomplie.reflection;

import javax.swing.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 应用反射的API，获取类的信息（类的名字，属性，方法，构造器等）
 *
 * @author cj
 */

@SuppressWarnings("all")
public class Demo02 {
    public static void main(String[] args) {
        String path = "com.cj.bean.User";
        try {
            Class clazz = Class.forName(path);
            //获取类的名字(包名+类名：全路径)
            System.out.println(clazz.getName());
            //获取类的名字（类名）
            System.out.println(clazz.getSimpleName());
            //获得属性信息
            Field[] fields = clazz.getDeclaredFields(); //获得所有的field
//            Field[] fields = clazz.getFields(); //只能获得public的field
            Field f = clazz.getDeclaredField("uname");
            System.out.println(fields.length);
            for (Field temp : fields) {
                System.out.println("属性：" + temp);
            }
            //获取方法信息
            Method[] methods = clazz.getDeclaredMethods();
            Method m01 = clazz.getDeclaredMethod("getUname", null);
            //如果方法有参数，则必须传递参数类型对应的class对象
            Method m02 = clazz.getDeclaredMethod("setUname", String.class);
            for (Method temp : methods) {
                System.out.println("方法：" + temp);
            }
            //获取构造器信息
            Constructor[] constructors = clazz.getDeclaredConstructors();
            Constructor c = clazz.getDeclaredConstructor(int.class, int.class, String.class);
            System.out.println("获得构造器为：" + c);
            for (Constructor temp : constructors) {
                System.out.println("构造器：" + temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
