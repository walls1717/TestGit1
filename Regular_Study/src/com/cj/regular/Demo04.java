package com.cj.regular;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 测试正则表达式对象分割字符串的操作
 */

public class Demo04 {
    public static void main(String[] args) {
        String str = "a2134aasdf2314asdf2345a23d355";
        String[] arrs = str.split("\\d+");
        System.out.println(Arrays.toString(arrs));
    }
}
