package com.cj.annotation;

/**
 * @author CJ
 */
public @interface MyAnno {
    /*String show();
    int show2();

    Person p1er();

    MyAnno2 anno2();

    String[] strs();*/

    int value();
//    String name() default "张三";

    Person per();

    MyAnno2 anno2();

    String[] strs();

}
