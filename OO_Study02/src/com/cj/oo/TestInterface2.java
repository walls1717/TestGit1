package com.cj.oo;

/**
 * 接口的多继承
 * 类没有多继承，接口有多继承
 * @author CJ
 */

public class TestInterface2 {
}

interface A{
    void testa();
}
interface B{
    void testb();
}
//接口的多继承：接口C继承接口A，B
interface C extends A, B{
    void testc();
}
class Mysubclass implements C{

    @Override
    public void testa() {

    }

    @Override
    public void testb() {

    }

    @Override
    public void testc() {

    }
}