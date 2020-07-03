/*
package com.cj.jvm.dynamiccomplie.common;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

*/
/**
 * 读取内容
 *
 * @author CJ
 *//*


public class CIOTest03 {
    public static void main(String[] args) throws IOException {
        //读取文件
        String msg = FileUtils.readFileToString(new File("print.txt"), "UTF-8");
        System.out.println(msg);
        byte[] datas = FileUtils.readFileToByteArray(new File("print.txt"));
        System.out.println(datas.length);

        //逐行读取
        List<String> msgs = FileUtils.readLines(new File("print.txt"), "UTF-8");
        for (String string : msgs) {
            System.out.println(string);
        }
        LineIterator it = FileUtils.lineIterator(new File("print.txt"), "UTF-8");
        while (it.hasNext()) {
            System.out.println(it.nextLine());
        }
    }
}
*/
