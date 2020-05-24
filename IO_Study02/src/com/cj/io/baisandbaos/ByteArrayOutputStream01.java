package com.cj.io.baisandbaos;

import java.io.*;

/**
 * 字节数组输出流 ByteArrayOutputStream
 * 1.创建源：内部维护
 * 2.选择流：不关联源
 * 3.操作
 * 4.释放资源：可以不用
 *
 * 获取数据：toByteArray
 * @author CJ
 */

public class ByteArrayOutputStream01 {
    public static void main(String[] args){
        //1.创建源
        byte[] dest = null;
        //2.选择流(新增方法)
        java.io.ByteArrayOutputStream baos = null;
        try {
            baos = new java.io.ByteArrayOutputStream();
            //3.操作
            String msg = "show me the code";
            byte[] datas = msg.getBytes();
            baos.write(datas, 0, datas.length);
            baos.flush();
            //获取数据
            dest = baos.toByteArray();
            System.out.println(dest.length+"--->"+new String(dest, 0, baos.size()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            //4.释放资源
            try {
                if (null != baos) {
                    baos.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
