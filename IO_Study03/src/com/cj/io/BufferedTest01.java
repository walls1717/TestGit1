package com.cj.io;

import java.io.*;

/**
 * 四个步骤：分段读取 文件字节输入流  加入缓冲流
 * 1.创建源
 * 2.选择流
 * 3.操作
 * 4.释放资源
 *
 * @author CJ
 */

public class BufferedTest01 {
    public static void main(String[] args) {

    }

    public static void test1() {
        //1.创建源
        File src = new File("D:/IntelliJ IDEA/Test/IO_Study02/abc.txt");
        //2.选择流
        InputStream is = null;
        try {
            is = new BufferedInputStream(new FileInputStream(src));
            //3.操作（读取）
            byte[] flush = new byte[1024];
            int len = -1;
            while ((len = is.read(flush)) != -1) {
                String str = new String(flush, 0, len);
                System.out.println(str);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
