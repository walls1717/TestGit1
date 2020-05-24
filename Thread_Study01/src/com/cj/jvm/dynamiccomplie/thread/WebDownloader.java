//package com.cj.jvm.dynamiccomplie.thread;
//
//import org.apache.commons.io.FileUtils;
//
//import java.io.File;
//import java.io.IOException;
//import java.net.URL;
//
///**
// * 下载图片
// * @author CJ
// */
//
//public class WebDownloader {
//    /**
//     * 下载工具
//     * @param url
//     * @param name
//     */
//    public void download(String url, String name){
//        try {
//            FileUtils.copyURLToFile(new URL(url), new File(name));
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("下载失败");
//        }
//    }
//}
