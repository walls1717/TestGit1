package cn.homework.webcrawler;

import java.util.Scanner;

/**
 * 爬虫程序主入口
 * @version 2020-6-22
 * @author CJ
 */
public class DoMain {

    public static void main(String[] args) {
        System.out.print("请输入一个 URL：");
        var sc = new Scanner(System.in);
        String url = sc.nextLine();
        var webCrawler = new WebCrawler(url);
        webCrawler.getUrl();
        sc.close();
    }
}
