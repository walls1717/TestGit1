package com.cj.sorm.utils;

/**
 * 封装字符串常用操作
 *
 * @author CJ
 */
public class StringUtils {
    /**
     * 将目标首字符串首字母变为大写
     * @param str 目标字符串
     * @return 首字母变为大写字符串
     */
    public static String firstChar2UpperCase(String str){
        //abcd-->Abcd
        //abcd-->ABCD-->Abcd
        return str.toUpperCase().substring(0, 1)+str.substring(1);
    }
}
