package com.cj.iowork;

import java.io.*;

public class Fops {
    public static void main(String[] args) {
        //创建输出流对象
        File dest = new File("dest.txt");
        //选择输出流
        FileOutputStream os = null;
        try {
            os = new FileOutputStream(dest);
            String msg = "FileOutputStream";
            byte[] datas = msg.getBytes(); //将字符串转化为字节数组
            os.write(datas); //写入字符串 msg
            os.flush(); //写入之后要刷新
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
