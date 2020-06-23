package cn.homework.webcrawler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 爬取 url
 * @version 2020-6-22
 * @author CJ
 */
public class WebCrawler {

    private final String webUrl;

    /**
     * 在创建对象的时候，传入 url 地址
     * @param webUrl 传入的 url 地址
     */
    public WebCrawler(String webUrl) {
        this.webUrl = webUrl;
    }

    public void getUrl() {
        // 待处理的 url
        ArrayList<String> list1 = new ArrayList<>();
        // 将要输出的 url
        ArrayList<String> list2 = new ArrayList<>();

        // 将输入的 url 地址添加到 list1 中
        list1.add(webUrl);

        // 需要输出多少条 url
        int length = 20;

        // 判断输入的 url 是否为空，一共输出 20 条 url 信息。
        while (!list1.isEmpty() && list2.size() <= length) {
            // 将输入的 url 存入 urlSting 中，并移除。
            String urlString = list1.remove(0);
            System.out.println("list1.size：" + list1.size());

            // 如果 list2 中不包含这条输入的 url
            if (!list2.contains(urlString)) {
                // 将输入的 url 放入 list2 中
                list2.add(urlString);
                System.out.println("发现URL：" + urlString);

                // 每有一条新的 url，就会遍历这条 url 里面的所有 url
                for (String s : getSubUrl2(urlString)) {
                    // 如果 list2 中不包含这条 url，那么将这条 url 存入 list1 中。
                    if (!list2.contains(s)) {
                        list1.add(s);
                    }
                }
            }
        }
        System.out.println("运行结束");
    }


    private ArrayList<String> getSubUrl(String urlString) {
        // 用来存放 url
        ArrayList<String> list = new ArrayList<>();

        try {
            // 创建 url 对象
            URL url = new URL(urlString);

            // 获取 url 的输入流
            Scanner value = new Scanner(url.openStream());

            // 用来表示是否读取到 url
            int current = 0;
            while (value.hasNext()) {
                String nextLine = value.nextLine();

                // 返回 http:// 第一次出现的位置
                current = nextLine.indexOf("http://", current);

                while (current > 0) {
                    int endIndex = nextLine.indexOf("\"", current);
                    if (endIndex > 0) {
                        list.add(nextLine.substring(current, endIndex));
                        current = nextLine.indexOf("http://", endIndex);
                    } else {
                        current = -1;
                    }
                }
            }
            value.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<String> getSubUrl2(String urlString) {
        // 正则表达式
        String regex = "(ht|f)tp(s?)\\:\\/\\/[0-9a-zA-Z]([-.\\w]*[0-9a-zA-Z])*(:(0-9)*)*(\\/?)([a-zA-Z0-9\\-\\.\\?\\,\\'\\/\\\\\\+&amp;%\\$#_]*)?";

        ArrayList<String> list = new ArrayList<>();

        try {
            URL url = new URL(urlString);
            //下载资源
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            //默认get请求方式：从服务器获取资源
            //post方式：提交数据
            conn.setRequestMethod("GET");
            conn.setRequestProperty(
                    "User-Agent",
                    " Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36 Edge/18.18363");
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
            String msg = null;
            while (null != (msg = br.readLine())) {
                Pattern p = Pattern.compile(regex);
                Matcher m = p.matcher(msg);
                while (m.find()) {
                    list.add(m.group(0));
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
