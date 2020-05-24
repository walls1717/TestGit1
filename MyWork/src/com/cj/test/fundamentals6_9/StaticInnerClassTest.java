package com.cj.test.fundamentals6_9;

/**
 * @version 2020-5-7
 * @author CJ
 */
public class StaticInnerClassTest {
    public static void main(String[] args) {
        var values = new double[20];
        for(int i = 0; i < values.length; i++) {
            values[i] = 100 * Math.random();
        }

        ArrayAlg.Pair p = ArrayAlg.minmax(values);
        System.out.println("min = " + p.getFirst());
        System.out.println("max = " + p.getSecond());
    }
}
