package cn.operator;

/**
 * 位运算符
 * @author CJ
 */

public class TestOperator09 {
    public static void main(String[] args){
        int a = 2;
        int b = 3;
        System.out.println("~a:"+~a);//按位取反
        System.out.println("a^b:"+(a^b));//按位异或
        System.out.println("a|b:"+(a|b));//按位或
        System.out.println("a&b:"+(a&b));//按位与

        a = 5;
        long b2 = 5L;
        System.out.println("a>>2:"+(a>>2));//右移运算符，右移一位相当于除2取商
        System.out.println("b<<2:"+(b2<<100));//左移运算符，左移一位相当于乘2
    }
}
