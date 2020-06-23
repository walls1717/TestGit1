package cn.homework.webcrawler.test;

import cn.homework.webcrawler.WebCrawler;
import org.junit.Test;

/**
 * 测试
 * @author CJ
 */
public class WebCrawlerTest {

    @Test
    public void test() {
        String url = "https://blog.csdn.net/weixin_37860686/article/details/79373570?utm_medium=distribute.pc_relevant.none-task-blog-baidujs-4";
        WebCrawler webCrawler = new WebCrawler(url);
        webCrawler.getSubUrl2(url);
    }
}
