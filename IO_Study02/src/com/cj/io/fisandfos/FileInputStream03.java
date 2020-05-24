package com.cj.io.fisandfos;

import java.io.*;

/**
 * 四个步骤：分段读取 文件字节输入流
 * 1.创建源
 * 2.选择流
 * 3.操作
 * 4.释放资源
 * @author CJ
 */

public class FileInputStream03 {
    public static void main(String[] args){
        //1.创建源
        File src = new File("D:/IntelliJ IDEA/Test/IO_Study02/abc.txt");
        //2.选择流
        InputStream is = null;
        try {
            is = new FileInputStream(src);
            //3.操作（读取）
            int temp;
            while ((temp = is.read()) != -1) {
                System.out.print((char)temp);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
