package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Element对象功能
 * @version 2020-6-10
 * @author CJ
 */
public class JsoupDemo4 {
    public static void main(String[] args) throws IOException {
        String path = JsoupDemo4.class.getClassLoader().getResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");

        // 通过 Document 对象获取 name 标签，获取所有的 name 标签，可以获取到两个
        Elements elements = document.getElementsByTag("name");
        System.out.println(elements.size());

        System.out.println("-----------------");

        // 通过 Element 对象获取子标签对象
        Element elementStudent = document.getElementsByTag("student").get(0);
        Elements eleName = elementStudent.getElementsByTag("name");
        System.out.println(eleName.size());

        // 获取 student 对象的属性值
        String number = elementStudent.attr("number");
        System.out.println(number);

        System.out.println("------------------");

        // 获取文本内容
        String text = eleName.text();
        String html = eleName.html();
        System.out.println(text);
        System.out.println(html);
    }
}
