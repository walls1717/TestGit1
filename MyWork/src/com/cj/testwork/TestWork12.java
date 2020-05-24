package com.cj.testwork;

/**
 * 关于值传递的练习
 * @author CJ
 */

public class TestWork12 {
    int count=9;//首先定义了count的值为9
    public void count1(){
        count=10;
        System.out.print("count1="+count);
    }
    public void count2(){
        System.out.print("count2="+count);
    }
    public static void main(String[ ] args) {
        TestWork12 t = new TestWork12();//此处创建了一个姓的对象，并将地址赋给了t，于是t就指向该对象，此时count的值为9
        System.out.println(t.count);//验证了count为9
        t.count1();//t执行方法count1，这个方法中对count重新赋值，所以10覆盖了之前的9，count的值变为10
        t.count2();//再次调用count2，t指向的对象不变，此时对象里面的count值已经被修改为10，所以输出也为10
    }
}
