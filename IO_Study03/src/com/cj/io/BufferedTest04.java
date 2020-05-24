package com.cj.io;

import java.io.*;

/**
 * 文件字符输出流  加入缓冲流
 * 1.创建源
 * 2.选择流
 * 3.操作（写出内容）
 * 4.释放资源
 * @author CJ
 */

public class BufferedTest04 {
    public static void main(String[] args){
        //1.创建源
        File dest = new File("dest.txt");
        //2.选择流
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(dest));
//            //3.操作（写出内容）
              //写法一
//            String msg = "IO is so easy\r\nCJ欢迎你";
//            char[] datas = msg.toCharArray();//字符串-->字符数组（编码 ）
//            writer.write(datas, 0, datas.length);

            //写法二
//            String msg = "IO is so easy\r\nCJ欢迎你";
//            writer.write(msg);
//            writer.write("add");
//            writer.flush();

            //写法三
            writer.append("IO is so easy\r\n");
            writer.newLine();
            writer.append("CJ欢迎你");
            writer.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //4.释放资源
                if (null != writer) {
                    writer.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
