package com.cj.oo;

/**
 * 测试String
 * @author CJ
 */

public class TestString {
    public static void main(String[] args){
        //定义字符串的方法
        String str = "abc";
        String str2 = new String("vdc");
        String str3 = "absc" + "sdfg";
        String str4 = "18" + 19; //不是加法了，是字符串连接符
        System.out.println(str4);

        System.out.println("#########################");
        String str10 = "CJ";
        String str11 = "CJ";
        String str12 = new String("CJ");

        System.out.println(str10 == str11);
        System.out.println(str11 == str12); //str11和str12不是同一个对象

        //通常比较字符串的时候使用equals
        System.out.println(str12.equals(str11));
    }
}
