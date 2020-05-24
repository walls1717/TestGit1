package cn.operator;

/**
 * 关系运算符
 * @author CJ
 */

public class TestOperator06 {
    public static void main(String[] args){
        int a = 4;
        int b = 3;

        char c1 = 'c';
        char c2 = 'j';

        //测试关系运算符
        System.out.println(a==3);
        System.out.println(a!=b);
        System.out.println(a>b);
        System.out.println(a<b);
        System.out.println(a>=b);
        System.out.println(a<=b);

        System.out.println(c1<c2);
        System.out.println((int)c1);//将c1强制转化为int型
        System.out.println((int)c2);
        System.out.println(c2+2);//结果为int型
    }
}