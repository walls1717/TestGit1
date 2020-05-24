package cn.cj.io;

import java.io.File;

/**
 * 创建目录
 * 1.mkdir()：确保上级目录存在，不存在创建失败
 * 2.mkdir()：上级目录可以不存在，不存在一同创建
 * @author CJ
 */

public class DirDemo01 {
    public static void main(String[] args){
        File dir = new File("D:/IntelliJ IDEA/Test/dir/test");
        //创建目录 mkdirs()
        boolean flag = dir.mkdirs();
        System.out.println(flag);
        //创建目录 mkdir()
        dir = new File("D:/IntelliJ IDEA/Test/dir/test2");
        flag = dir.mkdirs();
        System.out.println(flag);
    }
}
