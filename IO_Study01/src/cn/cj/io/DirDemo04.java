package cn.cj.io;

import javax.swing.*;
import java.io.File;

/**
 * 递归：方法自己调用自己
 * 打印子孙级目录名称
 *
 * @author CJ
 */

public class DirDemo04 {
    public static void main(String[] args){
        File src = new File("D:/IntelliJ IDEA/Test");
        printName(src, 0);
    }

    //打印子孙级目录和文件的名称
    public static void printName(File src, int deep){

        //控制前面层次感
        for(int i = 0; i < deep; i++){
            System.out.print("-");
        }

        System.out.println(src.getName());//打印文件名字

        //如果文件不存在或者为空，什么也不返回
        if (null == src || !src.exists()) { //递归头
            return;
            //如果是文件夹就打印名称
        } else if (src.isDirectory()) { //目录

            //递归体
            for(File s:src.listFiles()){
                printName(s, deep+1);
            }

        }
    }
}
