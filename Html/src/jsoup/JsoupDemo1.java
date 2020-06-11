package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.File;

/**
 * @version 2020-6-10
 * @author CJ
 */
public class JsoupDemo1 {
    public static void main(String[] args) throws Exception {
        // 获取 student.xml 的 path
        String path = Jsoup.class.getClassLoader().getResource("student.xml").getPath();
        // 解析 xml 文档，加载文档进内存，获取 dom 树 Document 对象
        Document document = Jsoup.parse(new File(path), "utf-8");
        // 获取元素对象 Element 对象
        Elements elements = document.getElementsByTag("name");
        System.out.println(elements.size());
        // 获取第一个 name 的 Element 对象
        Element element = elements.get(0);
        // 获取数据
        String name = element.text();
        System.out.println(name);
    }
}
