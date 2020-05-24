package com.cj.booktest.test2_8;

import java.util.Date;

public class Work20 {
    public static void main(String[] args) {
        short a = 1;
        int b = a;
        //因为b的范围比a大，所以发生了自动类型转化，将a的short类型转化为了b的int类型
        System.out.println(b);

        byte aa = 100;
        short c = 200;
        int d = 100;
        long e = 100000L;
        boolean t = true;
        boolean f = false;
        float fl = 1.234F;
        double db = 1.3453345;
        char ch = 'a';
        String str = "CJ";

        System.out.println(new Date());
    }
}
