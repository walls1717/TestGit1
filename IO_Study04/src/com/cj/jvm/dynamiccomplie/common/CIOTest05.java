package com.cj.jvm.dynamiccomplie.common;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * 拷贝
 *
 * @author CJ
 */

public class CIOTest05 {
    public static void main(String[] args) throws IOException {
//        //复制文件
//        FileUtils.copyFile(new File("p.jpg"), new File("p-copy.jpg"));

//        //复制文件到目录
//        FileUtils.copyFileToDirectory(new File("p.jpg"), new File("dest"));

//        //复制目录到目录
//        FileUtils.copyDirectoryToDirectory(new File("dest"), new File("dest2"));

//        //复制目录
//        FileUtils.copyDirectory(new File("dest"), new File("dest2"));

//        //拷贝URL内容
//        String url = "www.baidu.com";
//        FileUtils.copyURLToFile(new URL(url), new File("baiduURL.txt"));

        String datas = IOUtils.toString(new URL("http://www.163.com"), "GBK");
        System.out.println(datas);
    }
}
