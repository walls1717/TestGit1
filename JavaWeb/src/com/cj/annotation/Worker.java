package com.cj.annotation;

/**
 * @author CJ
 */
@MyAnno(value = 1, per = Person.P1, anno2 = @MyAnno2, strs = {"abc", "123"})
@MyAnno3
public class Worker {
    public void test() {}
}
