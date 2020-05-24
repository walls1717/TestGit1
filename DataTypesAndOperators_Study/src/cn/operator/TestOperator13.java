package cn.operator;

/**
 * 逻辑运算符一些例子
 * @author CJ
 */

public class TestOperator13 {
    public static void main(String[] args){
        int i = 5;
        String b = (Integer.toBinaryString(i));//二进制表达
        System.out.println(i+"的二进制表达是:"+b);

        //计算2*16
        System.out.println(2<<4);

        System.out.println("#########################");
        i = -10;
        System.out.println(Integer.toBinaryString(i));
        int j = i>>1;
        System.out.println(Integer.toBinaryString(j));
        System.out.println(j);
        int k = i>>>1;
        System.out.println(Integer.toBinaryString(k));
        System.out.println(k);
    }
}
