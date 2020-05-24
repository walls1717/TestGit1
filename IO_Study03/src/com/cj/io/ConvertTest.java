package com.cj.io;

import java.io.*;

/**
 * 转化流：InputStreamReader OutputStreamWriter
 * 1.以字符流的形式操作字节流（纯文本）
 * 2.指定字符集
 *
 * @author CJ
 */

public class ConvertTest {
    public static void main(String[] args) {
        //操作System.in System.out
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));) {

            //循环获取键盘输入（exit推出），输出次内容
            String msg = "";
            while (!msg.equals("exit")) {
                msg = reader.readLine();//循环读取
                writer.write(msg);//循环写出
                writer.newLine();
                writer.flush();//强制刷新
            }
        } catch(IOException e) {
            System.out.println("操作异常");
        }
    }
}
