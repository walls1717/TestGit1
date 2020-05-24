package com.cj.io.utils;

import com.cj.io.baisandbaos.ByteArrayInputStream01;
import com.cj.io.baisandbaos.ByteArrayOutputStream01;

import java.io.*;

/**
 * 1.封装拷贝
 * 2.封装释放
 * try ...with...resource
 *
 * @author CJ
 */

public class FileUtils02 {
    public static void main(String[] args) {
        //文件到文件
        try {
            InputStream is = new FileInputStream("D:/IntelliJ IDEA/Test/IO_Study02/abc.txt");
            OutputStream os = new FileOutputStream("abc-copy.txt");
            copy(is, os);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //文件到字节数组
        byte[] datas = null;
        try {
            InputStream is = new FileInputStream("e8.gif");
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            copy(is, os);
            datas = os.toByteArray();
            System.out.println(datas.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //字节数组到文件
        try {
            InputStream is = new ByteArrayInputStream(datas);
            OutputStream os = new FileOutputStream("p-copy.gif");
            copy(is, os);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 对接输入输出流
     * try ...with...resource
     *
     * @param is
     * @param os
     */
    public static void copy(InputStream is, OutputStream os) {
        try (is; os) {
            //3.操作（分段读取）
            byte[] flush = new byte[1024];//缓冲容器
            int len = -1;//接收长度
            while ((len = is.read(flush)) != -1) {
                os.write(flush, 0, len);
            }
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
