package cn.cj.io;

import java.io.File;

/**
 * 统计文件夹的大小
 *
 *
 * @author CJ
 */

public class DirDemo05 {
    public static void main(String[] args){
        File src = new File("D:/IntelliJ IDEA/Test");
        count(src);
        System.out.println(len);
    }

    private static long len = 0;
    public static void count(File src){

        //获取大小
        if (null != src && src.exists()) {
            if (src.isFile()) { //大小
                len += src.length();
            } else {  //子孙级
                for(File s:src.listFiles()){
                    count(s);
                }
            }
        }
    }
}
