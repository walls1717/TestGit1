package cn.cj.io;

import java.io.File;

/**
 * 使用面向对象统计文件夹的大小
 *
 *
 * @author CJ
 */

public class DirCount {
    //大小
    private long len;
    //文件夹路径
    private String path;
    //源
    private File src;
    //文件的个数
    private int fileSize;
    //文件夹的个数
    private int dirSize;
    //构造器，进行构造
    public DirCount(String path) {
        this.path = path;
        this.src = new File(path);
        count(src);
    }

    //统计大小
    private void count(File src){

        //获取大小
        if (null != src && src.exists()) {
            if (src.isFile()) { //大小
                len += src.length();
                this.fileSize++;
            } else {  //子孙级
                this.dirSize++;
                for(File s:src.listFiles()){
                    count(s);
                }
            }
        }
    }

    //获取文件夹大小
    public long getLen() {
        return len;
    }

    //获取文件个数
    public int getFileSize() {
        return fileSize;
    }

    //获取文件夹个数
    public int getDirSize() {
        return dirSize;
    }

    public static void main(String[] args){
        DirCount dir = new DirCount("D:/IntelliJ IDEA/Test");
        System.out.println(dir.getLen()+"-->"+dir.getFileSize()+"-->"+dir.getDirSize());

        DirCount dir2 = new DirCount("D:/IntelliJ IDEA/Test/MyPro01");
        System.out.println(dir2.getLen()+"-->"+dir2.getFileSize()+"-->"+dir2.getDirSize());
    }
}
