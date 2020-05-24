package com.cj.jvm.dynamiccomplie.thread;

/**
 * lambda推导 + 参数
 *
 * @author CJ
 */

public class LambdaTest04 {

    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("一边学习lambda");
            }
        }).start();

        //简化
        new Thread(() -> System.out.println("一边崩溃中")).start();
    }
}