package com.cj.jvm;

import java.io.*;

/**
 * 加密工具类
 *
 * @author CJ
 */

public class EncryptUtil {
    public static void main(String[] args) {
        encrypt("E:/MyJavaTest/HelloWorld.class", "E:/MyJavaTest/temp/HelloWorld.class");
    }

    public static void encrypt(String src, String dest) {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(src);
            fos = new FileOutputStream(dest);
            int temp = -1;
            while ((temp = fis.read()) != -1) {
                fos.write(temp ^ 0xff); //取反操作
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
