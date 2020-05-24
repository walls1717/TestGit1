package com.cj.recursion;

public class RecursionTest {
    public static void main(String[] args) {
        int res = factorial(10);
        System.out.println(res);
    }

    //打印问题
    public static void test(int n) {
        if (n > 1) {
            test(n - 1);
        } /*else {
            System.out.println("n=" + n);
        }*/
    }

    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }
}
