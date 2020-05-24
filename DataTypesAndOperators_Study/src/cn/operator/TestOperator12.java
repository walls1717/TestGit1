package cn.operator;

/**
 * 运算符的优先级问题
 * @author CJ
 */

public class TestOperator12 {
    public static void main(String[] args){
        int a = 3;
        int b = 4;
        System.out.println(a>b || a==0 && b==1);//逻辑非>逻辑与>逻辑或，则a>b || (a==0 && b==1)
    }
}
