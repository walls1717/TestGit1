package com.cj.jvm.dynamiccomplie.thread;

/**
 * lambda推导 + 参数
 *
 * @author CJ
 */

public class LambdaTest02 {

    public static void main(String[] args) {
        ILove love = (int a) -> {
            System.out.println("i like lambda-->" + a);
        };
        love.lambda(100);

        //简化1.0
        love = (a) -> {
            System.out.println("i like lambda-->" + a);
        };
        love.lambda(50);
        //简化2.0
        love = a -> {
            System.out.println("i like lambda-->" + a);
        };
        love.lambda(5);
        //简化3.0
        love = a -> System.out.println("i like lambda-->" + a);
        love.lambda(0);
    }


}

interface ILove {
    void lambda(int a);
}

//外部类
class Love implements ILove {

    @Override
    public void lambda(int a) {
        System.out.println("i like lambda-->" + a);
    }
}