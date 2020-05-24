package com.cj.jvm.dynamiccomplie.loc;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 网络爬虫的原理 + 模拟浏览器
 * @author CJ
 */

public class SpiderTest02 {
    public static void main(String[] args) throws Exception {
        //获取URL
        URL url = new URL("https://www.dianping.com");
        //下载资源
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        //默认get请求方式：从服务器获取资源
        //post方式：提交数据
        conn.setRequestMethod("GET");
        conn.setRequestProperty(
                "User-Agent"," Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36 Edge/18.18363");
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        String msg = null;
        while (null != (msg = br.readLine())) {
            System.out.println(msg);
        }
        br.close();
        //分析
        //处理
    }
}
