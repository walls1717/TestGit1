package com.cj.io.fisandfos;

import java.io.*;

/**
 * 第一个程序：理解操作步骤
 * 1.创建源
 * 2.选择流
 * 3.操作
 * 4.释放资源
 * @author CJ
 */

public class FileInputStream01 {
    public static void main(String[] args){
        //1.创建源
        File src = new File("D:/IntelliJ IDEA/Test/IO_Study02/abc.txt");
        //2.选择流
        try {
            InputStream is = new FileInputStream(src);
            //3.操作（读取）
            int data1 = is.read();//第一个数据 c
            int data2 = is.read();//第二个数据 j
            int data3 = is.read();//第三个数据 a
            int data4 = is.read();//????不是数据，文件的末尾返回-1
            System.out.println((char)data1);
            System.out.println((char)data2);
            System.out.println((char)data3);
            System.out.println(data4);
            //4.释放资源
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
