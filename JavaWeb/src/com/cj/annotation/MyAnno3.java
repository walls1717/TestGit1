package com.cj.annotation;

import java.lang.annotation.*;

/**
 * 元注解的使用方式
 * @version 2020-5-21
 * @author CJ
 */

@Target(value = {ElementType.TYPE}) // 表示该 MyAnno3 注解只能作用在类上。
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MyAnno3 {
}
