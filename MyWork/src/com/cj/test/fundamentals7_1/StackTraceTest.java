package com.cj.test.fundamentals7_1;

import java.util.Scanner;

/**
 * 分析堆栈轨迹元素
 * @version 2020-5-13
 * @author CJ
 */
class StackTraceTest {
    public static void main(String[] args) {
        try(var in = new Scanner(System.in)) {
            System.out.print("Enter n: ");
            int n = in.nextInt();
            factorial(n);
        }
    }

    /**
     * 计算数字的阶乘，并展示出栈内情况。
     * @param n 需要计算阶乘的数字
     * @return 返回阶乘
     */
    private static int factorial(int n) {
        System.out.println("factorial(" + n + "): ");
        var walker = StackWalker.getInstance();
        walker.forEach(System.out::println);
        int r;
        if (n <= 1) {
            r = 1;
        } else {
            r = n * factorial(n - 1);
        }
        System.out.println("return " + r);
        return r;
    }
}