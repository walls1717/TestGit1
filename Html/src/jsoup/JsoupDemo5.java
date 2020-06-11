package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * 选择器查询
 * @version 2020-6-10
 * @author CJ
 */
public class JsoupDemo5 {
    public static void main(String[] args) throws IOException {
        String path = JsoupDemo5.class.getClassLoader().getResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");

        // 查询 name 标签
        Elements elements = document.select("name");
        System.out.println(elements);

        System.out.println("-------------------");

        // 查询 id 值为 cj 的元素
        Elements elements1 = document.select("#cj");
        System.out.println(elements1);

        System.out.println("-------------------");

        // 获取 student 标签并且 number 属性值为 heima_0001 的 age 子标签
        Elements student = document.select("student[number='heima_0001']");
        System.out.println(student);

        System.out.println("-------------------");
        Elements elements3 = document.select("student[number='heima_0001'] > age");
        System.out.println(elements3);
    }
}
