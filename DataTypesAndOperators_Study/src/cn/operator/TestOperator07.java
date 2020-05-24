package cn.operator;

/**
 * 逻辑运算符
 * @author CJ
 */

public class TestOperator07 {
    public static void main(String[] args){
        int a = 1;
        int b = 2;

        System.out.println("a>b & a==b:"+(a>b & a==b));//两个都为true时为true，否则时false；两个表达式都要成立
        System.out.println("a<b | a==b:"+(a<b | a==b));//两个操作数有一个是true，结果就为true；两个表达式成立一个
        System.out.println("a==b && a<=b:"+(a==b && a<=b));//只要有一个为false，结果就为false；短路与
        System.out.println("a>=b || a<=b:"+(a>=b || a<=b));//只要有一个为true，结果就为true；短路或
        System.out.println("!(a==b):"+(!(a==b)));//取反，操作数为true，结果为false；操作数为false，结果为true
        System.out.println("a<b ^ a==b:"+(a<b ^ a==b));//两个操作数相同结果为false，不相同为true

        //短路
        boolean b2 = 1>2 && 2<(3/0);//短路与，第一个计算为false则直接返回false，不需要计算后面的
        System.out.println(b2);
    }
}
