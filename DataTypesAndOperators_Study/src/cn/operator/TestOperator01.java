package cn.operator;

/**
 * 测试算数运算符
 * @author CJ
 */

public class TestOperator01 {
    public static void main(String[] args){
        byte a = 1;
        int b = 2;
        long b2 = 3;
//        byte c = a+b;//因为b为int型，a加上b也为int型，不能放入byte型里
//        int c2 = b2+b;//因为b2为long型，所以b2加上b的结果也为long型，不能放入int型里

        float f1 = 3.14F;
        double d = b+b2;//也可以执行，double范围较大

//        float d2 = f1+6.2;//只要有一个类型为double结果就是double

        //取余测试
        System.out.println(-9%5);//"余数%" 符号和左边操作数相同，左边数的正负决定取余结果的正负
        System.out.println(9%-5);
        System.out.println(9%5);

        //自增运算符测试
        int x = 3;
        int y = x++;
        System.out.println("x="+x+"\ny="+y);//执行完后x=3，先给y赋值，再自增

        x = 3;
        y = ++x;
        System.out.println("x="+x+"\ny="+y);//先进行自增，自增完后x=4，再对y赋值

        //自减运算符测试
        int x1 = 3;
        int y1 = x1--;
        System.out.println("x1="+x1+"\ny1="+y1);//x1=2,y1=3

        x1 = 3;
        y1 = --x1;
        System.out.println("x1="+x1+"\ny1="+y1);//x1=2,y1=2

        //自增小练习
        int i = 1;
        int j = ++i + i++ + ++i + ++i +i++;
        System.out.println("i="+i+"\nj="+j);
    }
}
