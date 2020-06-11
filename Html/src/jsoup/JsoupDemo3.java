package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Document/Element对象功能
 * @version 2020-6-10
 * @author CJ
 */
public class JsoupDemo3 {
    public static void main(String[] args) throws IOException {
        // 获取 xml 的 path
        String path = JsoupDemo3.class.getClassLoader().getResource("student.xml").getPath();
        // 获取 Document对象
        Document document = Jsoup.parse(new File(path), "utf-8");
        // 获取元素对象
        Elements elements = document.getElementsByTag("student");
        System.out.println(elements);

        System.out.println("--------------------");

        // 获取属性名为 id 的元素对象们
        Elements id = document.getElementsByAttribute("id");
        System.out.println(id);

        System.out.println("--------------------");

        // 获取 number 属性值为 heima_0001
        Elements elementsByAttributeValue = document.getElementsByAttributeValue("number", "heima_0001");
        System.out.println(elementsByAttributeValue);

        System.out.println("--------------------");

        // 获取 id 属性值的元素对象
        Element cj = document.getElementById("cj");
        System.out.println(cj);
    }
}
