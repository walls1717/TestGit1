package com.cj.test;

public class StringBuilderTest {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();

        String ch = "Hello";

        stringBuilder.append("aaa\n");
        stringBuilder.append("bbb\n");
        stringBuilder.append(ch);

        String str = stringBuilder.toString();
        System.out.println(str);
        System.out.println(stringBuilder.length());

        String name = "CJ";
        int age = 18;
        String str2 = String.format("Hello %S, age is %d", name, age);
        System.out.println(str2);
    }
}
