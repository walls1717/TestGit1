package com.cj.jvm.dynamiccomplie.annotation;

@MyAnnotation01
public class Demo02 {
    @MyAnnotation01(age = 19, studentName = "CJ"
            , id = 1001, schools = {"北京大学"})
    public void test() {
    }

    @MyAnnotation02("aa")
    public void test02(){

    }
}
