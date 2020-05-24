package com.cj.io.baisandbaos;

import java.io.*;

/**
 * 四个步骤：字节数组输入流
 * 1.创建源：字节数组，不要太大
 * 2.选择流
 * 3.操作
 * 4.释放资源：可以不用处理
 * @author CJ
 */

public class ByteArrayInputStream01 {
    public static void main(String[] args){
        //1.创建源
        byte[] src = "talk is cheap show me the code".getBytes();
        //2.选择流
        InputStream is = null;
        try {
            is = new java.io.ByteArrayInputStream(src);
            //3.操作（读取）
            byte[] flush = new byte[5];
            int len = -1;
            while ((len = is.read(flush)) != -1) {
                String str = new String(flush, 0, len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
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
