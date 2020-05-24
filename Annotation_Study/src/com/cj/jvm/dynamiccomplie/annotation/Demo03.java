package com.cj.jvm.dynamiccomplie.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 使用反射读取注解信息，模拟处理注解流程
 * @author CJ
 */

public class Demo03 {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("com.cj.jvm.dynamiccomplie.annotation.CjStudent");

            //获得类所有的注解
            Annotation[] annotations =clazz.getAnnotations();
            for(Annotation a:annotations){
                System.out.println(a);
            }

            //获得类的指定的注解
            CjTable cj = (CjTable) clazz.getAnnotation(CjTable.class);
            System.out.println(cj.value());

            //获得类的属性的直接
            Field f = clazz.getDeclaredField("studentName");
            CjField cjfield = f.getAnnotation(CjField.class);
            System.out.println(cjfield.columnName()+"-->"+cjfield.type()+"-->"+cjfield.length());

            //根据获得的表名，字段信息，拼出DDL语句，然后，使用JDBC执行这个SQL，在数据库生成相关的表

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
