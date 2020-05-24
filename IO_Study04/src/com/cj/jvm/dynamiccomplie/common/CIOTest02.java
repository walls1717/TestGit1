package com.cj.jvm.dynamiccomplie.common;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;

import java.io.File;
import java.util.Collection;

/**
 * 列出子孙级
 * @author CJ
 */

public class CIOTest02 {
    public static void main(String[] args){
        //查看下一级的文件
        Collection<File> files = FileUtils.listFiles(
                new File("D:/IntelliJ IDEA/Test"),
                EmptyFileFilter.NOT_EMPTY, null);
//        for(File file:files){
//            System.out.println(file.getAbsolutePath());
//        }


        //查看所有子孙级的文件
        System.out.println("-----------------------");
        files = FileUtils.listFiles(
                new File("D:/IntelliJ IDEA/Test"),
                EmptyFileFilter.NOT_EMPTY, DirectoryFileFilter.INSTANCE);
//        for(File file:files){
//            System.out.println(file.getAbsolutePath());
//        }


        //
        System.out.println("--------------------------");
        files = FileUtils.listFiles(
                new File("D:/IntelliJ IDEA/Test"),
                new SuffixFileFilter("java"), DirectoryFileFilter.INSTANCE);
//        for(File file:files){
//            System.out.println(file.getAbsolutePath());
//        }


        System.out.println("--------------------------");
        files = FileUtils.listFiles(
                new File("D:/IntelliJ IDEA/Test"),
                FileFilterUtils.or(new SuffixFileFilter("java"),new SuffixFileFilter("class")), DirectoryFileFilter.INSTANCE);
//        for(File file:files){
//            System.out.println(file.getAbsolutePath());
//        }


        System.out.println("--------------------------");
        files = FileUtils.listFiles(
                new File("D:/IntelliJ IDEA/Test"),
                FileFilterUtils.or(new SuffixFileFilter("java"),new SuffixFileFilter("class"),EmptyFileFilter.EMPTY),
                DirectoryFileFilter.INSTANCE);
//        for(File file:files){
//            System.out.println(file.getAbsolutePath());
//        }

        System.out.println("--------------------------");
        files = FileUtils.listFiles(
                new File("D:/IntelliJ IDEA/Test"),
                FileFilterUtils.and(new SuffixFileFilter("java"),EmptyFileFilter.NOT_EMPTY),
                DirectoryFileFilter.INSTANCE);
        for(File file:files){
            System.out.println(file.getAbsolutePath());
        }
    }
}
