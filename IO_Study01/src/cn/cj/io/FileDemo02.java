package cn.cj.io;

import java.io.File;

/**
 * @author CJ
 */

public class FileDemo02 {
    /**
     * 构建File对象
     * 相对路径与绝对路径
     *
     * 1.存在盘符：绝对路径
     * 2.不存在盘符：相对路径，当前目录：user.dir
     *
     * @param args
     */
    public static void main(String[] args){
        String path = "D:/IntelliJ IDEA/Test/gg.txt";

        //绝对路径
        File src = new File(path);
        System.out.println(src.getAbsolutePath());

        //相对路径，就是相对于当前工程的路径
        System.out.println(System.getProperty("user.dir"));//显示当前工程的路径
        src = new File("gg.txt");
        System.out.println(src.getAbsolutePath());

        //构建一个不存在的文件
        src = new File("aaa/xx.txt");//可以构建一个不存在的路径
        System.out.println(src.getAbsolutePath());
    }
}
