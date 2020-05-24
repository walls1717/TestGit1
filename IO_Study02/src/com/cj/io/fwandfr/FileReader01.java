package com.cj.io.fwandfr;

import java.io.*;

/**
 * 四个步骤：分段读取 文件字符输入流
 * 1.创建源
 * 2.选择流
 * 3.操作
 * 4.释放资源
 * @author CJ
 */

public class FileReader01 {
    public static void main(String[] args){
        //1.创建源
        File src = new File("D:/IntelliJ IDEA/Test/IO_Study02/abc.txt");
        //2.选择流
        Reader reader = null;
        try {
            reader = new java.io.FileReader(src);
            //3.操作
            char[] flush = new char[1024];
            int len = -1;
            while((len = reader.read(flush)) != -1){
                //字符数组-->字符串
                String str = new String(flush, 0, len);
                System.out.println(str);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //4.释放资源
            try {
                if (null != reader) {
                    reader.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
