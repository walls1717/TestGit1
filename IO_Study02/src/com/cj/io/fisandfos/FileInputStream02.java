package com.cj.io.fisandfos;

import java.io.*;

/**
 * 第一个程序：理解操作步骤 标准
 * 1.创建源
 * 2.选择流
 * 3.操作
 * 4.释放资源
 * @author CJ
 */

public class FileInputStream02 {
    public static void main(String[] args){
        //1.创建源
        File src = new File("D:/IntelliJ IDEA/Test/IO_Study02/abc.txt");
        //2.选择流
        InputStream is = null;
        try {
            is = new FileInputStream(src);
            //3.操作（分段读取）
            byte[] flush = new byte[1024*10];//缓冲容器
            int len = -1;//接收长度
            while ((len = is.read(flush)) != -1) {
                //字节数组-->字符串（解码）
                String str = new String(flush, 0, len);
                System.out.println(str);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            //4.释放资源
            try {
                if (null != is) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
