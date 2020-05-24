package com.cj.jvm.dynamiccomplie.thread;

/**
 * lambda推导 + 参数
 *
 * @author CJ
 */

public class LambdaTest03 {

    public static void main(String[] args) {
        IInterest interest = (int a, int c) -> {
            System.out.println("i like lambda-->" + (a + c));
            return a + c;
        };
        interest.lambda(100, 200);

        //简化1.0
        interest = (a, c) -> {
            System.out.println("i like lambda-->" + (a + c));
            return a + c;
        };
        interest.lambda(200, 200);

        //简化2.0
        interest = (a, c) -> a + c;
        System.out.println(interest.lambda(10, 20));
    }
}

interface IInterest {
    int lambda(int a, int b);
}

//外部类
class Interest implements IInterest {

    @Override
    public int lambda(int a, int c) {
        System.out.println("i like lambda-->" + (a + c));
        return a;
    }
}