package com.cj.oo;

/**
 * 测试String的常用方法
 * @author CJ
 */

public class TestString2 {
    public static void main(String[] args){
        String s1 = "core Java";
        String s2 = "Core Java";
        System.out.println(s1.charAt(3));//提取下标为3的字符

        System.out.println(s2.length());//字符串长度

        System.out.println(s1.equals(s2));//判断两个字符串是否相等
        System.out.println(s1.equalsIgnoreCase(s2));//不区分大小写判断两个字符串是否相等

        System.out.println(s1.indexOf("Java"));//字符串中是否出现Java，如果出现则返回J第一次出现的位置
        System.out.println(s1.indexOf("apple"));//如果没有出现则返回-1

        String s = s1.replace(' ', '&');//将s1中的空格替换成&， s1本体不会产生变化，此处是产生了一个新的字符串
        System.out.println("result is :"+s);

        String s3 = "";
        String s4 = "How are you?";
        System.out.println(s4.startsWith("How"));//判断字符串是否从How开头
        System.out.println(s4.endsWith("you"));//判断字符串是否为you结尾

        s3 = s4.substring(4);//提取从第四个字符开始到结尾
        System.out.println(s3);
        s3 = s4.substring(4, 7);//提取从第四个字符到第六个字符，也就是[4,7)
        System.out.println(s3);

        s3 = s4.toLowerCase();//将字符串转化为小写
        System.out.println(s3);
        s3 = s4.toUpperCase();//将字符串转化为大写
        System.out.println(s3);

        String s5 = " How old are you! ";
        s3 = s5.trim();//去除字符串前后的空格，中间的不能去掉
        System.out.println(s3);
        System.out.println(s5);//因为String是不可变字符串，所以s5不改变
    }
}
