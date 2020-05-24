package cn.cj.io;

import java.io.File;

/**
 * 其他信息
 * length()：字节数
 * @author CJ
 */

public class FileDemo05 {
    public static void main(String[] args){
        File src = new File("D:/IntelliJ IDEA/Test/gg.txt");
        System.out.println("长度："+src.length());

        src = new File("D:/IntelliJ IDEA/Test");
        System.out.println("长度："+src.length());

        src = new File("D:/IntelliJ IDEA");
        System.out.println("长度："+src.length());
    }
}