package com.cj.jvm;

/**
 * 测试简单的加密解密（取反）操作
 *
 * @author CJ
 */

public class Demo04 {
    public static void main(String[] args) throws Exception {
        //测试取反操作
//        int a = 3; //011
//        System.out.println(Integer.toBinaryString(a^0xff));

        FileSystemClassLoader loader = new FileSystemClassLoader("e:/MyJavaTest/temp");
        Class<?> c = loader.loadClass("HelloWorld");
        System.out.println(c);
    }
}
