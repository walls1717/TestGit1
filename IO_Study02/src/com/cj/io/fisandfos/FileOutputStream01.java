package com.cj.io.fisandfos;

import java.io.*;

/**
 * 文件字节输出流
 * 1.创建源
 * 2.选择流
 * 3.操作（写出内容）
 * 4.释放资源
 * @author CJ
 */

public class FileOutputStream01 {
    public static void main(String[] args){
        //1.创建源
        File dest = new File("dest.txt");
        //2.选择流
        OutputStream os = null;
        try {
            os = new FileOutputStream(dest, true);
            //3.操作（写出内容）
            String msg = "IO is so easy\r\n";
            byte[] datas = msg.getBytes();//字符串-->字节数组（编码 ）
            os.write(datas, 0, datas.length);
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                //4.释放资源
                if (null != os) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
