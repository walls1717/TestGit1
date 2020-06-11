package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.net.URL;

/**
 * Jsoup对象功能
 * @version 2020-6-10
 * @author CJ
 */
public class JsoupDemo2 {
    public static void main(String[] args) throws Exception {
        // 获取 student.xml 的 path
        String path = Jsoup.class.getClassLoader().getResource("student.xml").getPath();
        // 解析 xml 文档，加载文档进内存，获取 dom 树 Document 对象
        /*Document document = Jsoup.parse(new File(path), "utf-8");
        System.out.println(document);*/

        /*String str = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                "\n" +
                "<students>\n" +
                "    <student number=\"heima_0001\">\n" +
                "        <name>Jack</name>\n" +
                "        <age>200</age>\n" +
                "        <sex>female</sex>\n" +
                "    </student>\n" +
                "\n" +
                "    <student number=\"heima_0002\">\n" +
                "        <name>Lisa</name>\n" +
                "        <age>20</age>\n" +
                "        <sex>female</sex>\n" +
                "    </student>\n" +
                "</students>";
        Document document = Jsoup.parse(str);
        System.out.println(document);*/

        // 代表网络中的资源路径
        URL url = new URL("https://jsoup.org/download");
        Document document = Jsoup.parse(url, 10000);
        System.out.println(document);
    }
}
