package cn.cj.web.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 下载工具类
 * @version 2020-6-17
 * @author CJ
 */
public class DownloadUtils {
    public static String getFileName(String agent, String fileName) throws UnsupportedEncodingException {
        if( agent.contains("MSIE")) {
            // IE
            fileName = URLEncoder.encode(fileName, "utf-8");
            fileName = fileName.replace("+", " ");
        } else {
            // 其他
            fileName = URLEncoder.encode(fileName, "utf-8");
        }
        return fileName;
    }
}
