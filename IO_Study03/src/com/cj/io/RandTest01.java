package com.cj.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 随机读取和写入流 RandomAccessFile
 * @author CJ
 */

public class RandTest01 {
    public static void main(String[] args) throws IOException {
        //分多少块
        File src = new File("D:/IntelliJ IDEA/Test/IO_Study03/src/com/cj/io/CopyTxt.java");
        //总长度
        long len = src.length();
        //每块大小
        int blockSize = 1024;
        //块数：多少块
        int size = (int)Math.ceil(len*1.0/blockSize);
        System.out.println(size);
        //起始位置和实际大小
        int beginPos = 0;
        int actualSize = (int)(blockSize > len? len:blockSize);
        for(int i = 0; i < size; i++){
            beginPos = i * blockSize;
            if (i == size - 1) { //最后一块
                actualSize = (int)len;
            } else {
                actualSize = blockSize;
                len -= actualSize; //剩余量
            }
            System.out.println(i+"--->"+beginPos+"--->"+actualSize);
            split(i, beginPos, actualSize);
        }
    }

    //指定起始位置，读取剩余所有内容
    public static void test1() throws IOException {
        RandomAccessFile raf = new RandomAccessFile(new File("D:/IntelliJ IDEA/Test/IO_Study03/src/com/cj/io/CopyTxt.java"), "r");
        //随机读取
        raf.seek(2);
        //读取
        byte[] flush = new byte[1024];
        int len = -1;
        while ((len = raf.read(flush)) != -1) {
            System.out.println(new String(flush, 0, len));
        }

        raf.close();
    }
    //分块思想：起始 实际大小
    //指定第i块起始位置和实际长度
    public static void split(int i, int beginPos, int actualSize) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(new File("D:/IntelliJ IDEA/Test/IO_Study03/src/com/cj/io/CopyTxt.java"), "r");
        //随机读取
        raf.seek(2);
        //读取
        byte[] flush = new byte[1024];
        int len = -1;
        while ((len = raf.read(flush)) != -1) {
            if (actualSize > len) { //获取本次读取的所有内容
                System.out.println(new String(flush, 0, len));
                actualSize -= len;
            } else {
                System.out.println(new String(flush, 0, actualSize));
                break;
            }
        }

        raf.close();
    }
}
