package cn.study;

import cn.CJ.oo.TestPackage;

import java.util.Date;

import static java.lang.Math.PI;

public class Test {
    public static void main(String[] args){
        TestPackage testpackage = new TestPackage();
        String str;
        Date date = new Date();
        System.out.println(Math.PI);
        System.out.println(PI);//在导入的时候前面加上static在用的时候就可以不用写成Math.PI
    }
}
