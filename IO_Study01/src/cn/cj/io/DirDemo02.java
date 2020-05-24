package cn.cj.io;

import java.io.File;

/**
 * 列出下一级
 * 1.list()：列出下一级名称
 * 2.listFiles()：列出下一级File对象
 *
 * 列出所有的盘符：listRoots()
 * @author CJ
 */

public class DirDemo02 {
    public static void main(String[] args){
        File dir = new File("D:/IntelliJ IDEA/Test");

        //列出下级名称 list
        String[] subsNames = dir.list();
        for(String s:subsNames){
            System.out.println(s);
        }

        //下级对象 listFiles()
        File[] subsFiles = dir.listFiles();
        for(File s:subsFiles){
            System.out.println(s.getAbsolutePath());
        }

        //所有盘符
        File[] roots = dir.listRoots();
        for(File r:roots){
            System.out.println(r.getAbsolutePath());
        }
    }
}
