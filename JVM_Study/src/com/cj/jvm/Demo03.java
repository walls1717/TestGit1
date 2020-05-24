package com.cj.jvm;

/**
 * 测试自定义的FileSystemClassLoader
 *
 * @author CJ
 */

public class Demo03 {
    public static void main(String[] args) throws Exception {
        FileSystemClassLoader loader = new FileSystemClassLoader("E:/MyJavaTest");

        Class<?> c = loader.loadClass("com.cj.bean.HelloWorld");
        System.out.println(c);
    }
}
