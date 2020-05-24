package com.cj.booktest.test3_12;

/**
 * 求一个多位数的多位相加
 */
public class work2 {
    public static void main(String[] args) {
        int x = 1234;
        int j = x % 10;
        int i = x /10 % 10;
        int k = x /100 % 10;
        int y = x /1000 % 10;
        int m = j + i + k + y;
        System.out.println(m);
    }
}
