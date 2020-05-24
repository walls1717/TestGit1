package com.cj.booktest.test3_12;

public class Work3 {
    public static void main(String[] args) {
        for (int i = 2; i <= 6; i += 2) {
            System.out.println(factorial(i));
        }
    }

    private static int factorial(int num) {
        if (num == 0) {
            return 1;
        } else if (num < 0) {
            throw new RuntimeException("请输入正数");
        } else {
            return factorial(num - 1) * num;
        }
    }
}
