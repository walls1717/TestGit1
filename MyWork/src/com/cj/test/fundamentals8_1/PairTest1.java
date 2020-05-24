package com.cj.test.fundamentals8_1;

/**
 * 测试泛型
 * @version 2020-5-16
 * @author CJ
 */
public class PairTest1 {
    public static void main(String[] args) {
        String[] words = {"Marry", "had", "a", "little", "lamb"};
        Pair<String> mm = ArrayAlg.minmax(words);
        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());
    }
}
