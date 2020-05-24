package cn.cj.io;

import java.io.File;

/**
 * 名称或路径：名称
 * getName()：
 * getPath()：相对，绝对
 * getAbsolutePath()：绝对
 * getParent()：上路径，不存在返回null
 *
 * @author CJ
 */

public class FileDemo03 {
    public static void main(String[] args){
        File src = new File("D:/IntelliJ IDEA/Test/gg.txt");

        //基本信息
        System.out.println("名称："+src.getName());//获得文件名称
        System.out.println("路径："+src.getPath());//获得文件路径，定义时候的路径
        System.out.println("绝对路径："+src.getAbsolutePath());//获得文件的绝对路径
        System.out.println("父路径："+src.getParent());//获得文件的父路径，也是将最后一个名称分隔符的前一个
        System.out.println("父对象："+src.getParentFile().getName());//获得父对象
    }
}
