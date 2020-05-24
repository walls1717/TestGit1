package com.cj.booktest.test3_12;

public class Work {
    public static void main(String[] args) {
        int b1 = 1;
        int b2 = 1;
        System.out.println(b1 <<= 31);
        System.out.println(b2 <<= 31);
        System.out.println();
        System.out.println(b1 >>= 31);
        System.out.println(b2 >>= 31);
        System.out.println();
        System.out.println(b1 >>>= 31);
        System.out.println(b2 >>>= 1);
    }
}
