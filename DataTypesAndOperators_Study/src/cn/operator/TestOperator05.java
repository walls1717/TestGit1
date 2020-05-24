package cn.operator;

/**
 * 赋值及其扩展赋值运算符
 * @author CJ
 */

public class TestOperator05 {
    public static void main(String[] args){
        int a = 3;
        int b = 4;
        a += b;//a = a+b
        System.out.println("a="+a+"\nb="+b);

        a = 3;
        a *= b+3;//a = a*(b+3)
        System.out.println("a="+a+"\nb="+b);

        a = 1;
        b = 2;
        a -= b;//a = a-b
        System.out.println("a="+a);

        a = 2;
        a /= b;// a = a/b
        System.out.println("a="+a+"\tb="+b);

        a = 3;
        a %= b;//a = a%b
        System.out.println("a="+a+"\tb="+b);
    }
}