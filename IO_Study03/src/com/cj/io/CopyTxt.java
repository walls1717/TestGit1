package com.cj.io;

import java.io.*;

/**
 * 文件拷贝：文件字节输出、输出流
 *
 * @author CJ
 */

public class CopyTxt {
    public static void main(String[] args) {
        copy("D:\\IntelliJ IDEA\\Test\\gg.txt", "gg-copy.txt");
    }


    public static void copy(String srcPath, String destPath) {
        //1.创建源
        File src = new File(srcPath);//源头
        File dest = new File(destPath);//目的地
        //2.选择流
        try {
            BufferedReader br = new BufferedReader(new FileReader(src));
            BufferedWriter bw = new BufferedWriter(new FileWriter(dest));
            //3.操作（逐行读取）
            String line = null;
            int len = -1;//接收长度
            while ((line = br.readLine()) != null) {
                bw.write(line);//逐行写出
                bw.newLine();
            }
            bw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
