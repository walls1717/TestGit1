package com.cj.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 * 面向对象思想封装分割
 *
 * @author CJ
 */

public class SplitFile {
    //源头
    private File src;
    //目的地（文件夹）
    private String destDir;
    //所有分割后的文件存储路径
    private List<String> destPaths;
    //每块大小
    private int blockSize;
    //块数：多少块
    private int size;

    public SplitFile(String srcPath, String destDir) {
        this(srcPath, destDir, 1024);
    }

    public SplitFile(String srcPath, String destDir, int blockSize) {
        this.src = new File(srcPath);
        this.destDir = destDir;
        this.blockSize = blockSize;
        this.destPaths = new ArrayList<String>();

        //初始化
        init();

    }

    //初始化
    private void init() {
        //总长度
        long len = this.src.length();
        //每块大小
        int blockSize = 1024;
        //块数：多少块
        this.size = (int) Math.ceil(len * 1.0 / blockSize);
        //路径
        for (int i = 0; i < size; i++) {
            this.destPaths.add(this.destDir + "/" + i + "-" + this.src.getName());
        }
    }

    //分割
    //1.计算每一块的起止位置及大小
    //2.分割
    public void split() throws IOException {
        //总长度
        long len = src.length();
        //起始位置和实际大小
        int beginPos = 0;
        int actualSize = (int) (blockSize > len ? len : blockSize);
        for (int i = 0; i < size; i++) {
            beginPos = i * blockSize;
            if (i == size - 1) { //最后一块
                actualSize = (int) len;
            } else {
                actualSize = blockSize;
                len -= actualSize; //剩余量
            }
            System.out.println(i + "--->" + beginPos + "--->" + actualSize);
            splitDetail(i, beginPos, actualSize);
        }
    }

    //分块思想：起始 实际大小
    //指定第i块起始位置和实际长度
    private void splitDetail(int i, int beginPos, int actualSize) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(this.src, "r");
        RandomAccessFile raf2 = new RandomAccessFile(this.destPaths.get(i), "rw");
        //随机读取
        raf.seek(beginPos);
        //读取
        byte[] flush = new byte[1024];
        int len = -1;
        while ((len = raf.read(flush)) != -1) {
            if (actualSize > len) { //获取本次读取的所有内容
                raf2.write(flush, 0, len);
                actualSize -= len;
            } else {
                raf2.write(flush, 0, actualSize);
                break;
            }
        }
        raf2.close();
        raf.close();
    }

    public static void main(String[] args) throws IOException {
        SplitFile sf = new SplitFile(
                "D:/IntelliJ IDEA/Test/IO_Study03/src/com/cj/io/SplitFile.java",
                "dest");
        sf.split();
    }
}