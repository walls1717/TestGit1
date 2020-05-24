package com.cj.io;

import java.io.*;
import java.net.URL;

/**
 * 转化流：InputStreamReader OutputStreamWriter
 * 1.以字符流的形式操作字节流（纯文本）
 * 2.指定字符集
 *
 * @author CJ
 */

public class ConvertTest02 {
    public static void main(String[] args) {
        test2();
    }

    public static void test2() {
        //操作网络流：下载百度的源代码
        try (BufferedReader reader =
                     new BufferedReader(
                             new InputStreamReader(
                                     new URL("https://www.baidu.com").openStream(), "UTF-8"));
             BufferedWriter writer =
                     new BufferedWriter(
                             new OutputStreamWriter(
                                     new FileOutputStream("baidu.html"), "UTF-8"));) {
            //3.操作（读取）
            String msg;
            while ((msg = reader.readLine()) != null) {
                writer.write(msg);
                writer.newLine();
            }
            writer.flush();
        } catch (IOException e) {
            System.out.println("操作异常");
        }
    }

    public static void test1() {
        //操作网络流：下载百度的源代码
        try (InputStream is = new URL("https://www.baidu.com").openStream();) {
            //3.操作（读取）
            int temp;
            while ((temp = is.read()) != -1) {
//                System.out.print((char) temp);
            }
        } catch (IOException e) {
            System.out.println("操作异常");
        }
    }
}
