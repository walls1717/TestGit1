package cn.cj.io;

import java.io.File;

/**
 * @author CJ
 */

public class PathDemo01 {
    /**
     * \ / 名称分隔符 separator
     * @param args
     */
    public static void main(String[] args){
        String path = "D:\\IntelliJ IDEA\\Test\\gg.txt";
        System.out.println(File.separatorChar);
        //建议
        //1./
        path = "D:/IntelliJ IDEA/Test/gg.txt";
        System.out.println(path);
        //2.常量拼接
        path = "D:"+File.separator+"IntelliJ IDEA"+File.separator+"Test"+File.separator+"gg.txt";
        System.out.println(path);
    }
}
