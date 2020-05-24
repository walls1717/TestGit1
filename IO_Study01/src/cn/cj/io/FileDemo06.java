package cn.cj.io;

import java.io.File;
import java.io.IOException;

/**
 * 其他信息
 *
 * creatNewFile()：不存在才创建，存在创建成功
 * delete()：删除已经存在的文件
 *
 * @author CJ
 */

public class FileDemo06 {
    public static void main(String[] args) throws IOException {
        File src = new File("D:/IntelliJ IDEA/Test/xx.txt");
        boolean flag = src.createNewFile();//创建一个新的文件
        System.out.println(flag);
        flag = src.delete();
        System.out.println(flag);

        System.out.println("-------------");

        //不是文件夹
        src = new File("D:/IntelliJ IDEA/Test/yy");
        flag = src.createNewFile();//创建一个新的文件
        System.out.println(flag);

        flag = src.delete();
        System.out.println(flag);

        //补充：con com3...操作系统的设备名，不能正确创建
        src = new File("D:/IntelliJ IDEA/Test/con2");
        flag = src.createNewFile();
        System.out.println(flag);
    }
}