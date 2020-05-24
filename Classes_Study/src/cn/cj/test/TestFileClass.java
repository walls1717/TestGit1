package cn.cj.test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * 测试File类的基本用法
 * @author CJ
 */

public class TestFileClass {
    public static void main(String[] args) throws IOException {

        File f = new File("d:/a.txt");
        System.out.println(f);//此处打印的是f的路径
        f.renameTo(new File("d:/bb.txt"));
        //获取当前项目的目录
        System.out.println(System.getProperty("user.dir"));
        //创建一个文件
        File f2 = new File("gg.txt");
//        f2.createNewFile();
        File f1 = new File("D:/bb.txt");
        f1.delete();

        System.out.println("File是否存在："+f2.exists());
        System.out.println("File是否是目录："+f2.isDirectory());
        System.out.println("File是否是文件："+f2.isFile());
        System.out.println("File最后修改的时间："+new Date(f2.lastModified()));
        System.out.println("File的大小："+f2.length());
        System.out.println("File的文件名："+f2.getName());
        System.out.println("File的目录路径："+f2.getAbsolutePath());

        System.out.println("###################");

        File f3 = new File("d:/电影/华语/大陆");
//        boolean flag = f3.mkdir();//mkdir目录结构中有一个不存在，则不会创建整个目录树
        boolean flag = f3.mkdirs();//mkdirs目录结构中有不存在也没有关系，创建整个目录树
        System.out.println(flag);

    }
}
