package cn.cj.io;

import java.io.File;

/**
 * @author CJ
 */

public class FileDemo01 {
    /**
     * 构建File对象
     * @param args
     */
    public static void main(String[] args){
        String path = "D:/IntelliJ IDEA/Test/gg.txt";

        //1.构建File对象
        File src = new File(path);
        System.out.println(src.length());

        //2.构建File对象
        src = new File("D:/IntelliJ IDEA/Test", "gg.txt");
        src = new File("D:/IntelliJ IDEA", "Test/gg.txt");
        System.out.println(src.length());

        //3.构建File对象
        src = new File(new File("D:/IntelliJ IDEA/Test"), "gg.txt");
        System.out.println(src.length());
    }
}
