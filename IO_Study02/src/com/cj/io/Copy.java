package com.cj.io;

import java.io.*;

/**
 * 文件拷贝：文件字节输出、输出流
 *
 * @author CJ
 */

public class Copy {
    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        copy("D:\\IntelliJ IDEA\\Test\\gg.txt", "D:\\IntelliJ IDEA\\Test\\IO_Study02\\abc.txt");
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);
    }


    public static void copy(String srcPath, String destPath) {
        //1.创建源
        File src = new File(srcPath);//源头
        File dest = new File(destPath);//目的地
        //2.选择流
        InputStream is = null;//输入流
        OutputStream os = null;//输出流
        try {
            is = new BufferedInputStream(new FileInputStream(src));
            os = new BufferedOutputStream(new FileOutputStream(dest));
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
        } finally {
            try {
                //4.释放资源,分别关闭 先打开的后关闭
                if (null != os) {
                    os.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

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
