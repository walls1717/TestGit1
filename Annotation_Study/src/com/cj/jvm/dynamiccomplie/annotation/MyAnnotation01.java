package com.cj.jvm.dynamiccomplie.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 四种元注解
 * 1.Target：用于描述注解的使用范围（即：被描述的注解可以使用在什么地方）
 * 2.Retention：表示需要在什么级别保存该注释信息，用于描述注释的生命周期
 * 3.Documented
 * 4.Inherited
 *
 * @author CJ
 */

@Target(value = {ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation01 {
    String studentName() default "";
    int age() default 0;
    int id() default -1; // 表示不存在String indexOf("abc"); -1

    String[] schools() default {"清华大学"};
}
